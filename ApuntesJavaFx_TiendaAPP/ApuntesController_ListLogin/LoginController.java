package org.example.tiendaapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.tiendaapp.HelloApplication;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField editCorreo;

    @FXML
    private TextField editPass;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegistrar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        actions();
    }

    private void actions() {

        btnLogin.setOnAction(evet -> {

            // =====================================================
            // 🔹 1. VALIDACIÓN DE LOGIN
            // =====================================================
            // Recogemos los datos introducidos por el usuario
            String mail = editCorreo.getText();
            String pass = editPass.getText();

            // Simulación de login (datos fijos)
            if (mail.equals("admin@admin.com") && pass.equals("admin")) {

                // =====================================================
                // 🔹 2. CREACIÓN DE LA NUEVA VENTANA (Stage)
                // =====================================================

                // Creamos una nueva ventana
                Stage ventanaPrincipal = new Stage();

                // ❗ DUDA 1: ¿Por qué se llama "ventanaPrincipal"?
                // 👉 Respuesta:
                // NO es realmente la ventana principal de JavaFX
                //
                // - JavaFX solo tiene UNA ventana principal real (primaryStage)
                // - Esa se crea en la clase Application (método start())
                //
                // 👉 Aquí simplemente estás creando OTRA ventana más
                // El nombre "ventanaPrincipal" es solo un nombre que tú le has dado
                // Podrías llamarla "nuevaVentana" y funcionaría igual

                try {

                    // =====================================================
                    // 🔹 3. CARGA DEL FXML
                    // =====================================================

                    // FXMLLoader:
                    // - Lee el archivo form-view.fxml
                    // - Crea la interfaz gráfica (botones, inputs, etc.)
                    // - La conecta con su controlador
                    FXMLLoader fxmlLoader = new FXMLLoader(
                            HelloApplication.class.getResource("form-view.fxml")
                    );

                    // =====================================================
                    // 🔹 4. CREACIÓN DE LA SCENE
                    // =====================================================

                    // Scene = contenido visual de una ventana
                    // load() construye toda la interfaz del FXML
                    Scene scene = new Scene(fxmlLoader.load());

                    // =====================================================
                    // 🔹 5. ASIGNAR ESCENA A LA VENTANA
                    // =====================================================

                    // Le decimos a la ventana qué mostrar
                    ventanaPrincipal.setScene(scene);

                    // Configuración visual
                    ventanaPrincipal.setTitle("Formulario de administracion");

                    // Mostramos la ventana
                    ventanaPrincipal.show();

                    // =====================================================
                    // 🔹 6. CIERRE DE LA VENTANA ACTUAL (LOGIN)
                    // =====================================================

                    // ❗ DUDA 2: ¿Qué hace esta línea?
                    // ((Stage)(btnLogin.getScene().getWindow())).close();

                    // Paso a paso:

                    // 1. btnLogin → botón pulsado
                    // 2. getScene() → escena donde está el botón
                    // 3. getWindow() → ventana que contiene esa escena
                    // 4. (Stage) → lo convertimos a Stage
                    // 5. close() → cerramos esa ventana

                    Stage ventanaLogin = (Stage) btnLogin.getScene().getWindow();
                    ventanaLogin.close();

                    // =====================================================
                    // 🔥 RESULTADO FINAL
                    // =====================================================

                    // ❗ DUDA 3: ¿Por qué parece la ventana principal?

                    // 👉 Porque:
                    // - Has abierto una nueva ventana (ventanaPrincipal)
                    // - Has cerrado la ventana de login
                    //
                    // 💥 Solo queda UNA ventana abierta
                    // 👉 Por eso parece "la principal"
                    //
                    // ⚠️ Pero en realidad:
                    // - Es una ventana normal creada con new Stage()
                    // - No tiene ningún privilegio especial

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {

                // =====================================================
                // 🔹 LOGIN INCORRECTO
                // =====================================================
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Fallo");
                alert.setContentText("Fallo en login");
                alert.show();
            }
        });
    }
}