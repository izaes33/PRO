package org.example.tiendaapp.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.tiendaapp.HelloApplication;
import org.example.tiendaapp.data.DataSet;
import org.example.tiendaapp.model.User;

import java.io.IOException;
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

    // 🔴 NUEVO: botones añadidos
    @FXML private Button btnEliminar;
    @FXML private Button btnCerrar;

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

    // 🔴 NUEVO: contenedor principal para meter la lista dinámicamente
    /**
     * BORDERPANE COMO CONTENEDOR DINÁMICO:
     *
     * Este componente permite organizar la interfaz en zonas (top, left, right, center...).
     * En este caso lo usamos para insertar o quitar dinámicamente el ListView en la zona derecha.
     *
     * Ventaja:
     * - Podemos modificar la interfaz sin cambiar de escena
     * - Permite interfaces más dinámicas y reactivas
     */
    @FXML private BorderPane borderGeneral;

    // 🔴 NUEVO: lista visual de usuarios
    /**
     * Este componente sirve para mostrar listas de objetos.
     * En este caso, mostrará objetos de tipo User.
     *
     * IMPORTANTE:
     * - No guarda datos por sí mismo
     * - Solo representa visualmente una lista (ObservableList)
     */
    @FXML private ListView<User> listViewUsuarios;

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

    // 🔴 NUEVO:
    /**
     * LISTA AUXILIAR DE USUARIOS:
     *
     * Se crea como lista interna del controlador.
     * Sin embargo, en esta aplicación los datos reales están en DataSet.
     *
     * NOTA:
     * - Esto puede generar inconsistencia si no se usa correctamente
     * - Lo correcto sería trabajar siempre con DataSet
     */
    private ObservableList<User> listaUsers;

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

    /**
     * FÁBRICA DE VALORES PARA SPINNER:
     * Es el "cerebro matemático" de tu componente Spinner (el selector de edad).
     * El Spinner por sí solo es tonto (solo dibuja un cuadro con dos flechas).
     * El SpinnerValueFactory le da las reglas del juego: le dice que maneja
     * números enteros (Integer), que el rango es del 18 al 90, que empiece en 25,
     * y que salte de 1 en 1.
     * se define de forma genérica para coincidir con el FXML.
     */
    private SpinnerValueFactory modelEdad;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Se ejecuta automáticamente. Llamamos a nuestros métodos organizadores:
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

        // 🔴 NUEVO:
        /**
         * Inicializamos la lista de usuarios.
         * Aunque se crea aquí, la aplicación usa realmente DataSet como fuente principal.
         */
        listaUsers = FXCollections.observableArrayList();

        // Agrupa los radio buttons para que sean excluyentes (solo 1 a la vez)
        grupoGenero = new ToggleGroup();
        // Efecto visual de sombra para cuando pasemos el ratón
        shadow = new DropShadow();
    }

    //initGUI(): Aplica los modelos y configuraciones a los elementos visuales.
    private void initGUI() {

        /**
         * CONEXIÓN LISTVIEW - DATASET:
         * Enlazamos el ListView con la lista global del DataSet para que los datos sean persistentes.
         */
        listViewUsuarios.setItems(DataSet.getListUsers());

        //EXPLICACIÓN DE MÉTODOS DE CONEXIÓN VISTA-LÓGICA
        /** * 1. spinnerEdad.setValueFactory(...)
        * El Spinner es solo un contenedor. La "Factoría de Valores" (ValueFactory) es
        * la que define qué tipo de datos maneja (números, fechas, listas).
        * - setValueFactory: Método que le asigna el "motor" de datos al Spinner.
        * - (SpinnerValueFactory) modelEdad: Aquí hacemos un "cast" (conversión) porque
        * la variable spinnerEdad está declarada como Spinner<?> (genérico).
        * Le estamos diciendo: "Confía en mí, este modelo encaja con este Spinner". */
        spinnerEdad.setValueFactory((SpinnerValueFactory) modelEdad);

        /** * 2. grupoGenero.getToggles().addAll(...)
        * El ToggleGroup no tiene un método directo "add", funciona a través de una
         * lista interna. * * - getToggles(): Llama a la lista interna de botones que
         * el grupo está vigilando. * - addAll(radioMasc, radioFem): Añade de golpe
         * todos los RadioButtons que * queremos que sean excluyentes entre sí.
         * A partir de este momento, el objeto 'grupoGenero' escuchará los clics de
         * estos botones: si pulsas uno, él mandará la orden de desmarcar el otro. */
        grupoGenero.getToggles().addAll(radioMasc, radioFem);

        /** * 3. comboTipo.setItems(...) * Los componentes de selección (ChoiceBox,
         * ComboBox, ListView) funcionan * siempre con una lista de elementos.
         * setItems(perfiles): Este método "enchufa" la ObservableList que creamos
         * antes (con "Administrador", "Usuario", etc.) al componente visual.
         * Importancia: Al usar 'setItems' con una ObservableList, creamos un vínculo
         * dinámico. Si más tarde haces 'perfiles.add("Invitado")', el desplegable *
         * se actualizará solo sin tener que volver a llamar a este método. */
        comboTipo.setItems(perfiles);

        // 🔴 NUEVO:
        /**
         * CONEXIÓN LISTVIEW - DATASET:
         * Aquí enlazamos el ListView con la lista de usuarios del DataSet.
         * DataSet actúa como "almacén central de datos".
         * Gracias a ObservableList:
         * - Si añadimos o eliminamos usuarios en DataSet
         * - El ListView se actualiza automáticamente
         * Esto evita tener que refrescar manualmente la interfaz.
         */
        listViewUsuarios.setItems(DataSet.getListUsers());

        /**
         * CONFIGURACIÓN DINÁMICA DE LA INTERFAZ:
         * Dependiendo de si el CheckBox está marcado al iniciar, mostramos o no la lista a la derecha.
         */
        if (checkLista.isSelected()){
            borderGeneral.setRight(listViewUsuarios);
        } else {
            borderGeneral.setRight(null);
            }
        }

    /*actions(): Asigna los comportamientos (listeners) a las interacciones del usuario.
    Diferenciamos acciones:
    * -Directas-> Las que son diferentes a todas las demás (setOnAction).
    * -Indirectas-> Las que son compartidas por varios elementos (creando una clase anidada
    * con el/los tratamiento/s de un evento).
    * -Propiedades-> Cuando lo que se escucha es el cambio en las propiedades del estado
    * de un elemento.*/
    private void actions() {

        btnAgregar.setOnAction(event -> {
            // setOnAction es el clic normal del botón. Usamos una función lambda (event -> {})

            // 🔴 NUEVO:
            /**
             * VALIDACIÓN DE FORMULARIO:
             * Antes de crear el usuario comprobamos:
             * - Campos vacíos
             * - Selección de género
             * - Selección de perfil
             * Si algo falla: Se muestra un Alert WARNING
             * Esto evita datos incorrectos en la aplicación.
             */
            if (editNombre.getText().isEmpty()
                    || editPass.getText().isEmpty()
                    || editApellido.getText().isEmpty()
                    || editMail.getText().isEmpty()
                    || grupoGenero.getSelectedToggle() == null
                    || comboTipo.getSelectionModel().getSelectedIndex() == -1) {

                Alert dialogPane = new Alert(Alert.AlertType.WARNING);
                dialogPane.setHeaderText("Faltan datos");
                dialogPane.setContentText("Por favor comprueba todos los datos");
                dialogPane.show();

            } else {
                // Extracción de datos de la interfaz
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

                User user = new User(nombre,apellido,correo, pass, dni, genero,perfil,edad);

                // 🔴 NUEVO:
                /**
                 * GUARDADO EN DATASET:
                 * Añadimos el usuario a la lista global.
                 * Resultado:
                 * - El ListView se actualiza automáticamente
                 * - Todos los controladores ven el cambio
                 */
                DataSet.addUser(user);

                Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
                dialogPane.setHeaderText("Añadido correcto");
                dialogPane.setContentText("Usuario añadido con exito");
                dialogPane.show();

                // 🔴 NUEVO:
                /**
                 * LIMPIEZA DEL FORMULARIO:
                 * Llamamos a un método reutilizable
                 * para resetear todos los campos.
                 */
                clearFields();
            }
        });

        btnVaciar.setOnAction(event -> {

            // 🔴 NUEVO:
            /**
             * REUTILIZACIÓN DE MÉTODO:
             * En lugar de repetir código,
             * usamos clearFields()
             */
            clearFields();
        });

        btnCompobar.setOnAction(event -> {

            // 🔴 NUEVO
            /**
             * OBTENER ELEMENTO SELECCIONADO:
             * Recuperamos el usuario seleccionado en el ListView.
             * Si no hay ninguno → devuelve null
             */
            User user = listViewUsuarios.getSelectionModel().getSelectedItem();

            if (user==null){
                Alert dialogPane = new Alert(Alert.AlertType.ERROR);
                dialogPane.setHeaderText("Error");
                dialogPane.setContentText("No hay nada seleccionado");
                dialogPane.show();
            } else {
                System.out.println("nombre "+user.getNombre());
                System.out.println("apellido "+user.getApellido());
                System.out.println("correo "+user.getCorreo());
            }
        });

        // 🔴 NUEVO:
        /**
         * FLUJO DE ELIMINACIÓN:
         * 1. Capturamos el elemento seleccionado.
         * 2. Si existe, lo borramos de la lista (listaUsers).
         * 3. Limpiamos la selección visual con select(-1).
         */
        btnEliminar.setOnAction(event -> {

            User user = listViewUsuarios.getSelectionModel().getSelectedItem();

            if (user==null){
                Alert dialogPane = new Alert(Alert.AlertType.ERROR);
                dialogPane.setHeaderText("Error");
                dialogPane.setContentText("No hay nada seleccionado");
                dialogPane.show();
            } else {
                listaUsers.remove(user);

                Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
                dialogPane.setHeaderText("Eliminado");
                dialogPane.setContentText("Usuario eliminado con exito");
                dialogPane.show();

                // Deseleccionamos para evitar errores de referencia
                listViewUsuarios.getSelectionModel().select(-1);
            }
        });

        // 🔴 NUEVO:
        /**
         * CAMBIO DE VENTANA: Cargamos un nuevo FXML (login-view)
         * y cerramos la ventana actual.
         */
        btnCerrar.setOnAction(event -> {

            //1 - Creo stage
            Stage stage = new Stage();

            try {
                //2 - Cargo parte gráfica
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
                //3 - Creo escena
                Scene scene = new Scene(loader.load());

                //4 - Asocio stage a scene
                stage.setScene(scene);
                stage.setTitle("Tienda ThePower");
                stage.show();

                //5 - Cierro stage actual
                ((Stage)btnCerrar.getScene().getWindow()).close();
                // (voy desde uno de los elementos gráficos de la escena, a la escena, a la ventana, y al metodo close).

            } catch (IOException e){
                System.out.println("No se encuentra la ruta");
            }
        });

        /* Para los eventos del ratón (entrar y salir), en lugar de crear un código
        para cada botón, creamos una instancia de clase compartida y se la pasamos a todos. */

        /* 1. CREACIÓN DEL MANEJADOR ÚNICO (El "Vigilante"): * En lugar de crear un código
        distinto para cada botón, creamos una sola * instancia de nuestra clase especializada
        'ManejoRaton'. * Este objeto será el encargado de vigilar a todos los botones. */
        ManejoRaton manejador = new ManejoRaton();

        /* 2. ASIGNACIÓN DEL MANEJADOR: * Le decimos a cada botón que, cuando el ratón entre o salga,
        * llame siempre al mismo objeto 'manejador'. */
        btnCompobar.setOnMouseEntered(manejador);
        btnVaciar.setOnMouseEntered(manejador);
        btnAgregar.setOnMouseEntered(manejador);
        btnEliminar.setOnMouseEntered(manejador); // 🔴 NUEVO

        btnAgregar.setOnMouseExited(manejador);
        btnVaciar.setOnMouseExited(manejador);
        btnCompobar.setOnMouseExited(manejador);
        btnEliminar.setOnMouseExited(manejador); // 🔴 NUEVO

        // 🔴 NUEVO:
        /**
         * PROPIEDADES REACTIVAS (Listeners):
         * Escuchamos el cambio en la propiedad 'selected' del CheckBox.
         * Si cambia a true, insertamos el ListView en el lado derecho del BorderPane;
         * si cambia a false, lo eliminamos (null).
         */
        checkLista.selectedProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue){
                        borderGeneral.setRight(listViewUsuarios);
                    } else {
                        borderGeneral.setRight(null);
                    }
                });
    }

    // 🔴 NUEVO:
    /**
     * MÉTODO DE LIMPIEZA:
     * Centraliza la limpieza del formulario.
     * Evita duplicar código.
     */
    private void clearFields(){
        editNombre.clear();
        editMail.clear();
        editApellido.clear();
        editPass.clear();
        editDni.clear();
        comboTipo.getSelectionModel().select(-1);
        grupoGenero.selectToggle(null);
    }
    /* 3. CLASE INTERNA ESPECIALIZADA: * Al implementar EventHandler<MouseEvent>, esta
    clase se convierte en un * "escuchador" oficial de eventos de ratón. */
    class ManejoRaton implements EventHandler<MouseEvent> {

        /** * MÉTODO HANDLE: Es el "contestador automático". * Se ejecuta cada vez que
         * ocurre un evento en cualquiera de los botones. * Recibe un objeto 'event' que
         * contiene toda la información de lo que pasó. */
        @Override
        public void handle(MouseEvent event) {

            /* A. ¿QUÉ HA PASADO? (getEventType) * Usamos event.getEventType() para saber
            si el ratón entró o salió. * Esto nos permite usar la misma clase para poner
            y quitar efectos. */
            if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {

                /* B. ¿QUIÉN HA SIDO? (getSource) * event.getSource() nos devuelve el
                objeto exacto que disparó el evento. * Como getSource() devuelve un
                'Object' genérico, hacemos un CAST (Button) * para decirle a Java:
                "Trátalo como un botón, que quiero ponerle una sombra". */
                ((Button) event.getSource()).setEffect(shadow);

                /* C. LÓGICA ESPECÍFICA (Opcional): * Aunque la sombra es común para todos,
                si necesitamos que pase algo * diferente según el botón, comparamos el
                'getSource()' con nuestras variables @FXML. */
                if (event.getSource() == btnCompobar) {
                    System.out.println("El vigilante detecta: Ratón entró en COMPROBAR");
                } else if (event.getSource() == btnAgregar) {
                    System.out.println("El vigilante detecta: Ratón entró en AGREGAR");
                } else if (event.getSource() == btnVaciar) {
                    System.out.println("El vigilante detecta: Ratón entró en VACIAR");
                }

            } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {

                /* Al salir el ratón, usamos getSource() de nuevo para saber a quién * tenemos
                que quitarle el efecto (poniéndolo a null). */
                ((Button) event.getSource()).setEffect(null);
            }
        }
    }
}