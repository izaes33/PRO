package org.example.tiendaapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import org.example.tiendaapp.model.User;

import java.net.URL;
import java.util.ResourceBundle;

/*
 * Implementar Initializable obliga a tener el método initialize(),
 * que es el primer punto de entrada del controlador tras cargar la vista.
 */
public class FormController implements Initializable  {

    // Las etiquetas @FXML conectan los elementos del diseño visual con estas variables.
    @FXML private Button btnAgregar;
    @FXML private Button btnCompobar;
    @FXML private Button btnVaciar;
    @FXML private CheckBox checkLista;
    @FXML private ChoiceBox<String> comboTipo;
    @FXML private TextField editApellido;
    @FXML private TextField editDni;
    @FXML private TextField editMail;
    @FXML private TextField editNombre;
    @FXML private TextField editPass;
    @FXML private RadioButton radioFem;
    @FXML private RadioButton radioMasc;
    @FXML private Spinner<?> spinnerEdad; // Mejor si fuera Spinner<Integer>

    /* VARIABLES LÓGICAS (no vienen de la vista, las usamos para gestionar datos)
     * A diferencia de los @FXML, estas variables no se dibujan en la pantalla.
     * Son los "engranajes lógicos" que controlan a los elementos visuales.
     */

    /**
     * LISTA OBSERVABLE:
     * Es una lista especial de JavaFX ("observable" o vigilable). Guarda las
     * opciones de un menú desplegable ("Administrador", "Usuario", "Trabajador").
     * Su ventaja principal: Si en algún momento el código añade o borra un perfil
     * de esta lista, el componente visual (comboTipo) se actualizará en la
     * pantalla AUTOMÁTICAMENTE, sin tener que decirle a la vista que se repinte.
     */
    private ObservableList<String> perfiles;

    /**
     * FÁBRICA DE VALORES PARA SPINNER:
     * Es el "cerebro matemático" de tu componente Spinner (el selector de edad).
     * El Spinner por sí solo es tonto (solo dibuja un cuadro con dos flechas).
     * El SpinnerValueFactory le da las reglas del juego: le dice que maneja
     * números enteros (Integer), que el rango es del 18 al 90, que empiece en 25,
     * y que salte de 1 en 1.
     */
    private SpinnerValueFactory<Integer> modelEdad;

    /**
     * EFECTO VISUAL:
     * Es un objeto que encapsula un efecto de sombra paralela.
     * En lugar de crear una sombra nueva cada vez que pasamos el ratón por un botón
     * (lo que consumiría mucha memoria), la creamos una sola vez aquí.
     * Luego se la "prestamos" al botón con setEffect(shadow) y se la quitamos al salir.
     */
    private DropShadow shadow;

    /**
     * GRUPO DE EXCLUSIVIDAD:
     * Es un agrupador lógico (invisible) para botones de selección (RadioButtons).
     * Por defecto, el usuario podría marcar "Masculino" y "Femenino" a la vez.
     * Al meter ambos botones dentro de este ToggleGroup, se aplica la regla de
     * exclusividad: obliga a que SOLO UNO pueda estar seleccionado. Si marcas uno,
     * el grupo desmarca el otro automáticamente.
     */
    private ToggleGroup grupoGenero;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Se ejecuta automáticamente. Llamamos a nuestros métodos organizadores.
        instances();
        initGUI();
        actions();
    }

    /**
     * instances(): Crea los objetos lógicos que necesitamos antes de
     * aplicarlos a los elementos de la interfaz.
     */
    private void instances() {
        // Crea las reglas del Spinner: de 18 a 90, valor por defecto 25, salta de 1 en 1.
        modelEdad = new SpinnerValueFactory.IntegerSpinnerValueFactory(18,90,25,1);

        // ObservableList es una lista especial de JavaFX que avisa a la vista si sufre cambios
        perfiles = FXCollections.observableArrayList();
        perfiles.addAll("Administrador","Usuario","Trabajador");

        // Agrupa los radio buttons para que sean excluyentes (solo 1 a la vez)
        grupoGenero = new ToggleGroup();

        // Efecto visual de sombra para cuando pasemos el ratón
        shadow = new DropShadow();
    }


    //initGUI(): Aplica los modelos y configuraciones a los elementos visuales.
    private void initGUI() {
    //EXPLICACIÓN DE MÉTODOS DE CONEXIÓN VISTA-LÓGICA
/**
 * 1. spinnerEdad.setValueFactory(...)
 * El Spinner es solo un contenedor. La "Factoría de Valores" (ValueFactory) es
 * la que define qué tipo de datos maneja (números, fechas, listas).
 * * - setValueFactory: Método que le asigna el "motor" de datos al Spinner.
 * - (SpinnerValueFactory) modelEdad: Aquí hacemos un "cast" (conversión) porque
 * la variable spinnerEdad está declarada como Spinner<?> (genérico).
 * Le estamos diciendo: "Confía en mí, este modelo encaja con este Spinner".
 */
        spinnerEdad.setValueFactory((SpinnerValueFactory) modelEdad);

/**
 * 2. grupoGenero.getToggles().addAll(...)
 * El ToggleGroup no tiene un método directo "add", funciona a través de una lista interna.
 * * - getToggles(): Llama a la lista interna de botones que el grupo está vigilando.
 * - addAll(radioMasc, radioFem): Añade de golpe todos los RadioButtons que
 * queremos que sean excluyentes entre sí.
 * A partir de este momento, el objeto 'grupoGenero' escuchará los clics de
 * estos botones: si pulsas uno, él mandará la orden de desmarcar el otro.
 */
        grupoGenero.getToggles().addAll(radioMasc, radioFem);

/**
 * 3. comboTipo.setItems(...)
 * Los componentes de selección (ChoiceBox, ComboBox, ListView) funcionan
 * siempre con una lista de elementos.
 * * - setItems(perfiles): Este método "enchufa" la ObservableList que creamos
 * antes (con "Administrador", "Usuario", etc.) al componente visual.
 * - Importancia: Al usar 'setItems' con una ObservableList, creamos un vínculo
 * dinámico. Si más tarde haces 'perfiles.add("Invitado")', el desplegable
 * se actualizará solo sin tener que volver a llamar a este método.
 */
        comboTipo.setItems(perfiles);
    }


    //actions(): Asigna los comportamientos (listeners) a las interacciones del usuario.
    private void actions() {
        // setOnAction es el clic normal del botón. Usamos una función lambda (event -> {})
        btnAgregar.setOnAction(event -> {
            String nombre= editNombre.getText();
            String apellido= editApellido.getText();
            String correo= editMail.getText();
            String dni= editDni.getText();
            String pass= editPass.getText();

            // Del ChoiceBox y del Spinner, sacamos el modelo de selección y le pedimos el valor elegido
            String perfil= comboTipo.getSelectionModel().getSelectedItem();
            int edad = (int) spinnerEdad.getValue();

            // Averiguamos qué botón de radio del grupo está seleccionado y sacamos su texto
            String genero = ((RadioButton)(grupoGenero.getSelectedToggle())).getText();

            // Creamos un objeto User con todos los datos recogidos (para usarlo en BBDD, etc)
            User user = new User(nombre,apellido,correo, pass, dni, genero,perfil,edad);
            System.out.println("Usuario creado: " + user.getNombre());
        });

        btnVaciar.setOnAction(event -> {
            System.out.println("Pulsado el boton vaciar");
        });

        btnCompobar.setOnAction(event -> {
            System.out.println("Pulsado el boton comprobar");
        });

        /* Para los eventos del ratón (entrar y salir), en lugar de crear un código
        para cada botón, creamos una instancia de clase compartida y se la pasamos a todos. */
        /* 1. CREACIÓN DEL MANEJADOR ÚNICO (El "Vigilante"):
         * En lugar de crear un código distinto para cada botón, creamos una sola
         * instancia de nuestra clase especializada 'ManejoRaton'.
         * Este objeto será el encargado de vigilar a todos los botones.
         */
        ManejoRaton manejador = new ManejoRaton();

        /* 2. ASIGNACIÓN DEL MANEJADOR:
         * Le decimos a cada botón que, cuando el ratón entre o salga,
         * llame siempre al mismo objeto 'manejador'.
         */
        btnCompobar.setOnMouseEntered(manejador);
        btnVaciar.setOnMouseEntered(manejador);
        btnAgregar.setOnMouseEntered(manejador);

        btnAgregar.setOnMouseExited(manejador);
        btnVaciar.setOnMouseExited(manejador);
        btnCompobar.setOnMouseExited(manejador);
    }

    /* 3. CLASE INTERNA ESPECIALIZADA:
     * Al implementar EventHandler<MouseEvent>, esta clase se convierte en un
     * "escuchador" oficial de eventos de ratón.
     */
    class ManejoRaton implements EventHandler<MouseEvent> {

        /**
         * MÉTODO HANDLE: Es el "contestador automático".
         * Se ejecuta cada vez que ocurre un evento en cualquiera de los botones.
         * Recibe un objeto 'event' que contiene toda la información de lo que pasó.
         */
        @Override
        public void handle(MouseEvent event) {

            /* A. ¿QUÉ HA PASADO? (getEventType)
             * Usamos event.getEventType() para saber si el ratón entró o salió.
             * Esto nos permite usar la misma clase para poner y quitar efectos.
             */
            if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {

                /* B. ¿QUIÉN HA SIDO? (getSource)
                 * event.getSource() nos devuelve el objeto exacto que disparó el evento.
                 * Como getSource() devuelve un 'Object' genérico, hacemos un CAST (Button)
                 * para decirle a Java: "Trátalo como un botón, que quiero ponerle una sombra".
                 */
                ((Button) event.getSource()).setEffect(shadow);

                /* C. LÓGICA ESPECÍFICA (Opcional):
                 * Aunque la sombra es común para todos, si necesitamos que pase algo
                 * diferente según el botón, comparamos el 'getSource()' con nuestras variables @FXML.
                 */
                if (event.getSource() == btnCompobar) {
                    System.out.println("El vigilante detecta: Ratón entró en COMPROBAR");
                } else if (event.getSource() == btnAgregar) {
                    System.out.println("El vigilante detecta: Ratón entró en AGREGAR");
                } else if (event.getSource() == btnVaciar) {
                    System.out.println("El vigilante detecta: Ratón entró en VACIAR");
                }

            } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {

                /* Al salir el ratón, usamos getSource() de nuevo para saber a quién
                 * tenemos que quitarle el efecto (poniéndolo a null).
                 */
                ((Button) event.getSource()).setEffect(null);
            }
        }
    }
}