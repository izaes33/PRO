package org.example.tiendaapp.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import org.example.tiendaapp.model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnCompobar;

    @FXML
    private Button btnVaciar;

    @FXML
    private Button btnEliminar;

    @FXML
    private CheckBox checkLista;

    @FXML
    private ChoiceBox<String> comboTipo;

    // 🔹 ObservableList = LISTA DE DATOS DINÁMICA
    // Es como un ArrayList, pero con una diferencia clave:
    // -> Notifica automáticamente a la interfaz cuando cambia (añadir, eliminar, etc.)
    private ObservableList<String> perfiles;

    @FXML
    private TextField editApellido;

    @FXML
    private TextField editDni;

    @FXML
    private TextField editMail;

    @FXML
    private TextField editNombre;

    @FXML
    private TextField editPass;

    @FXML
    private RadioButton radioFem;

    @FXML
    private RadioButton radioMasc;

    @FXML
    private Spinner<?> spinnerEdad;

    private SpinnerValueFactory modelEdad;

    @FXML
    private BorderPane borderGeneral;

    // 🔹 ListView = COMPONENTE VISUAL (UI)
    // Sirve para mostrar una lista en pantalla
    // NO guarda los datos, solo los muestra
    @FXML
    private ListView<User> listViewUsuarios;

    // 🔹 ESTA es la lista REAL de datos que usa el ListView
    private ObservableList<User> listaUsers;

    private DropShadow shadow;
    private ToggleGroup grupoGenero;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instances();
        initGUI();
        actions();
    }

    private void initGUI() {

        // 🔥 AQUÍ ESTÁ LA CLAVE DE TODO:
        // Conectamos la lista de datos (ObservableList)
        // con la vista (ListView)
        listViewUsuarios.setItems(listaUsers);

        // 👉 Qué significa esto:
        // - listViewUsuarios NO tiene datos propios
        // - usa listaUsers como "fuente de datos"
        // - cualquier cambio en listaUsers se refleja automáticamente en pantalla

        spinnerEdad.setValueFactory(modelEdad);
        grupoGenero.getToggles().addAll(radioMasc, radioFem);
        comboTipo.setItems(perfiles);

        if (checkLista.isSelected()){
            borderGeneral.setRight(listViewUsuarios);
        } else {
            borderGeneral.setRight(null);
        }
    }

    private void instances() {

        modelEdad = new SpinnerValueFactory.IntegerSpinnerValueFactory(18, 90, 25, 1);

        // 🔹 Creamos ObservableList VACÍAS
        perfiles = FXCollections.observableArrayList();
        listaUsers = FXCollections.observableArrayList();

        // 👉 perfiles se usa para el ChoiceBox (combo)
        perfiles.addAll("Administrador", "Usuario", "Trabajador");

        grupoGenero = new ToggleGroup();
        shadow = new DropShadow();
    }

    private void actions() {

        btnAgregar.setOnAction(event -> {

            if (editNombre.getText().isEmpty()
                    || editPass.getText().isEmpty()
                    || editApellido.getText().isEmpty()
                    || editMail.getText().isEmpty()
                    || grupoGenero.getSelectedToggle() == null
                    || comboTipo.getSelectionModel().getSelectedIndex() == -1

            ) {
                Alert dialogPane = new Alert(Alert.AlertType.WARNING);
                dialogPane.setHeaderText("Faltan datos");
                dialogPane.setContentText("Por favor comprueba todos los datos");
                dialogPane.show();
            } else {

                String nombre = editNombre.getText();
                String apellido = editApellido.getText();
                String correo = editMail.getText();
                String dni = editDni.getText();
                String pass = editPass.getText();
                String perfil = comboTipo.getSelectionModel().getSelectedItem();
                int edad = (int) spinnerEdad.getValue();
                String genero = ((RadioButton) (grupoGenero.getSelectedToggle())).getText();

                User user = new User(nombre, apellido, correo, pass, dni, genero, perfil, edad);

                // 🔥 AQUÍ PASA LA MAGIA
                // Añadimos el usuario a la ObservableList
                listaUsers.add(user);

                // 👉 Automáticamente:
                // - el ListView se actualiza SOLO
                // - aparece el nuevo usuario en pantalla
                // 👉 NO necesitas hacer refresh ni nada manual

                Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
                dialogPane.setHeaderText("Añadido correcto");
                dialogPane.setContentText("Usuario añadido con exito");
                dialogPane.show();

                clearFields();
            }

        });

        btnVaciar.setOnAction(event -> {
            clearFields();
        });

        btnCompobar.setOnAction(event -> {

            /*El ListView permite seleccionar elementos
            pero realmente está accediendo a la ObservableList */
            User user = listViewUsuarios.getSelectionModel().getSelectedItem();
            /* getSelectionModel() ->
            // El ListView usa un "modelo de selección" interno que controla:
            El elemento seleccionado  ;  Los cambios de selección  ;
            selección múltiple o simple.
            Con esto accedemos a ese gestor interno:
            getSelectedItem() ->
            Le pide al modelo de selección el elemento seleccionado
            Puede devolver:
            Un objeto User → si hay selección
            null → si no hay nada seleccionado
            IMPORTANTE: El objeto que devuelve NO es una copia,
            es el mismo objeto que está dentro de la ObservableList (listaUsers)
            Es decir:
            Se obtiene directamente un elemento de la lista de datos */

            if (user == null){ /* Si es null significa
            que el usuario NO ha seleccionado nada en el ListView */
                Alert dialogPane = new Alert(Alert.AlertType.ERROR);
                dialogPane.setHeaderText("Error");
                dialogPane.setContentText("No hay nada seleccionado");
                dialogPane.show();
            } else { /* Si hay selección:
            "user" es exactamente el elemento clicado en la lista */
                System.out.println("nombre "+user.getNombre());
                System.out.println("apellido "+user.getApellido());
                System.out.println("correo "+user.getCorreo());

                /* CLAVE: Esto viene de la ObservableList (listaUsers)
                pero accedemos a él a través del ListView */
            }
        });

        btnEliminar.setOnAction(evet->{

            // 🔹 Obtenemos el seleccionado del ListView
            User user = listViewUsuarios.getSelectionModel().getSelectedItem();

            if (user==null){
                Alert dialogPane = new Alert(Alert.AlertType.ERROR);
                dialogPane.setHeaderText("Error");
                dialogPane.setContentText("No hay nada seleccionado");
                dialogPane.show();
            } else {

                // 🔥 IMPORTANTE:
                // Eliminamos del ObservableList (NO del ListView)
                listaUsers.remove(user);

                // 👉 Resultado:
                // - El ListView se actualiza automáticamente
                // - El elemento desaparece de la UI

                Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
                dialogPane.setHeaderText("Eliminado");
                dialogPane.setContentText("Usuario eliminado con existo");
                dialogPane.show();

                listViewUsuarios.getSelectionModel().select(-1);
            }
        });

        // Eventos de ratón (no relevantes para listas)
        btnCompobar.setOnMouseEntered(new ManejoRaton());
        btnVaciar.setOnMouseEntered(new ManejoRaton());
        btnAgregar.setOnMouseEntered(new ManejoRaton());
        btnEliminar.setOnMouseEntered(new ManejoRaton());
        btnAgregar.setOnMouseExited(new ManejoRaton());
        btnVaciar.setOnMouseExited(new ManejoRaton());
        btnCompobar.setOnMouseExited(new ManejoRaton());
        btnEliminar.setOnMouseExited(new ManejoRaton());

        // Mostrar/ocultar ListView
        checkLista.selectedProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue){
                        borderGeneral.setRight(listViewUsuarios);
                    } else {
                        borderGeneral.setRight(null);
                    }
                });
    }

    private void clearFields(){
        editNombre.clear();
        editMail.clear();
        editApellido.clear();
        editPass.clear();
        editDni.clear();
        comboTipo.getSelectionModel().select(-1);
        grupoGenero.selectToggle(null);
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                ((Button) event.getSource()).setEffect(shadow);

                if (event.getSource() == btnCompobar) {
                    System.out.println("Evento raton entrando bComprobar");
                } else if (event.getSource() == btnAgregar) {
                    System.out.println("Evento raton entrando bAgregar");
                } else if (event.getSource() == btnVaciar) {
                    System.out.println("Evento raton entrando bVaciar");
                }
            } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                ((Button) event.getSource()).setEffect(null);
            }
        }
    }
}