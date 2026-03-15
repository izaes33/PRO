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

    // Variables lógicas (no vienen de la vista, las usamos para gestionar datos)
    private ObservableList<String> perfiles;
    private SpinnerValueFactory<Integer> modelEdad;
    private DropShadow shadow;
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

    /**
     * initGUI(): Aplica los modelos y configuraciones a los elementos visuales.
     */
    private void initGUI() {
        // Le damos las reglas matemáticas al componente visual
        spinnerEdad.setValueFactory((SpinnerValueFactory) modelEdad);
        // Metemos los dos botones en el grupo para que peleen entre ellos por estar seleccionados
        grupoGenero.getToggles().addAll(radioMasc,radioFem);
        // Le pasamos la lista de perfiles al desplegable
        comboTipo.setItems(perfiles);
    }

    /**
     * actions(): Asigna los comportamientos (listeners) a las interacciones del usuario.
     */
    private void actions() {
        // setOnAction es el clic normal del botón. Usamos una función lambda (event -> {})
        btnAgregar.setOnAction(event -> {
            String nombre= editNombre.getText();
            String apellido= editApellido.getText();
            String correo= editMail.getText();
            String dni= editDni.getText();
            String pass= editPass.getText();

            // Del ChoiceBox, sacamos el modelo de selección y le pedimos el valor elegido
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

        // Para los eventos del ratón (entrar y salir), en lugar de crear un código
        // para cada botón, creamos una instancia de nuestra clase compartida y se la pasamos a todos.
        ManejoRaton manejador = new ManejoRaton();

        btnCompobar.setOnMouseEntered(manejador);
        btnVaciar.setOnMouseEntered(manejador);
        btnAgregar.setOnMouseEntered(manejador);

        btnAgregar.setOnMouseExited(manejador);
        btnVaciar.setOnMouseExited(manejador);
        btnCompobar.setOnMouseExited(manejador);
    }

    /**
     * Clase interna que implementa la interfaz EventHandler para capturar eventos del ratón.
     * Al ser una clase independiente, podemos reusarla en varios componentes.
     */
    class ManejoRaton implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent event) {
            // event.getEventType() nos dice QUÉ ha pasado (¿entró el ratón o salió?)
            if(event.getEventType() == MouseEvent.MOUSE_ENTERED){

                // event.getSource() nos dice QUIÉN ha disparado el evento.
                // Lo casteamos a (Button) para poder aplicarle la sombra.
                ((Button)event.getSource()).setEffect(shadow);

                // Si queremos diferenciar qué botón fue exactamente:
                if(event.getSource() == btnCompobar){
                    System.out.println("Evento raton entrando bComprobar");
                } else if (event.getSource() == btnAgregar){
                    System.out.println("Evento raton entrando bAgregar");
                } else if (event.getSource() == btnVaciar){
                    System.out.println("Evento raton entrando bVaciar");
                }

            } else if(event.getEventType() == MouseEvent.MOUSE_EXITED){
                // Si el ratón sale, le quitamos el efecto (pasando null)
                ((Button)event.getSource()).setEffect(null);
            }
        }
    }
}