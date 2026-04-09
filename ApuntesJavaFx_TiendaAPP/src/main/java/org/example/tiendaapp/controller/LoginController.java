package org.example.tiendaapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.tiendaapp.HelloApplication;
import org.example.tiendaapp.data.DataSet;
import org.example.tiendaapp.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * CONTROLADOR DE LOGIN:
 * Es la puerta de entrada de la aplicación.
 * Su función es validar credenciales y dirigir al usuario a la vista correcta según su rol.
 */
public class LoginController implements Initializable {

    @FXML private TextField editCorreo;
    @FXML private TextField editPass;
    @FXML private Button btnLogin;
    @FXML private Button btnRegistrar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // En esta vista sencilla, solo necesitamos configurar los eventos de los botones
        actions();
    }

    /**
     * actions(): Contiene la lógica del botón de acceso.
     */
    private void actions() {
        btnLogin.setOnAction(evet -> {

            // 1. Capturamos lo que el usuario ha escrito en las cajas de texto
            String mail = editCorreo.getText();
            String pass = editPass.getText();

            /**
             * CONSULTA AL DATASET:
             * DataSet funciona como nuestra "base de datos" temporal.
             * Buscamos si existe un usuario con ese correo y contraseña.
             */
            User user = DataSet.getLogin(mail, pass);

            if (user != null) {
                /**
                 * FLUJO DE CAMBIO DE VENTANA:
                 * Si el usuario es válido, abrimos una nueva ventana (Stage).
                 */

                // A. Creamos el contenedor de la nueva ventana (Stage)
                Stage ventanaPrincipal = new Stage();

                try {
                    // B. El cargador de FXML (FXMLLoader) nos permite leer el diseño visual
                    FXMLLoader fxmlLoader = null;

                    /**
                     * CONTROL DE ACCESO BASADO EN ROLES (RBAC):
                     * Dependiendo del perfil del usuario ("admin" o "usuario"),
                     * cargamos un archivo FXML diferente.
                     */
                    switch (user.getPerfil().toLowerCase()) {
                        case "admin":
                            // Si es administrador, va al formulario de gestión
                            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("form-view.fxml"));
                            ventanaPrincipal.setTitle("Formulario de administración");
                            break;
                        case "usuario":
                            // Si es cliente, va a la tienda de productos
                            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tienda-view.fxml"));
                            ventanaPrincipal.setTitle("Tienda de productos");
                            break;
                        default:
                            // Caso por defecto por seguridad
                            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
                    }

                    // C. Cargamos físicamente la vista
                    Parent parent = fxmlLoader.load();

                    // D. Creamos la escena, la ponemos en el escenario y la mostramos
                    Scene scene = new Scene(parent);
                    ventanaPrincipal.setScene(scene);
                    ventanaPrincipal.show();

                    /**
                     * CERRAR VENTANA ACTUAL:
                     * Para que no se queden ventanas "huérfanas", cerramos el Login.
                     * Obtenemos la ventana actual a través de cualquier elemento de la interfaz (btnLogin).
                     */
                    ((Stage) (btnLogin.getScene().getWindow())).close();

                } catch (IOException e) {
                    // Manejo de errores si el archivo FXML no existe o está corrupto
                    System.out.println("Error en la carga de la ruta: " + e.getMessage());
                }

            } else {
                /**
                 * FEEDBACK DE ERROR:
                 * Si el usuario no existe o la contraseña es mal, avisamos con un Alert.
                 */
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Fallo de acceso");
                alert.setHeaderText(null); // Quita el encabezado para un diseño más limpio
                alert.setContentText("Usuario o contraseña incorrectos. Por favor, inténtalo de nuevo.");
                alert.show();
            }
        });
    }
}