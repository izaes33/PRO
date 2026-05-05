package org.example.tiedafx.controller;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.tiedafx.TiendaApplication;
import org.example.tiedafx.dao.UserDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField editMail, editPass;

    @FXML
    private Button btnLogin;
    private UserDAO userDAO;
    private Task<int[]> taskLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        instances();
        actions();
    }

    private void instances() {
        userDAO = new UserDAO();

    }

    private void actions() {
        btnLogin.setOnAction(event -> {
            String correo = editMail.getText();
            String pass = editPass.getText();

            // con task
            // 1. DEFINICIÓN DE LA TAREA (El "Qué" vamos a hacer)
// Creamos una Task que, al finalizar, devolverá un arreglo de enteros (int[])
            taskLogin = new Task<int[]>() {
                @Override
                protected int[] call() throws Exception {
                    // Todo lo que está dentro de call() se ejecutará en SEGUNDO PLANO.
                    // Aquí va la lógica pesada (ej. consultar la base de datos).
                    // Esto evita que la pantalla se congele mientras espera la respuesta.
                    return userDAO.getLogin(correo, pass);
                }
            };

// 2. CREACIÓN Y EJECUCIÓN DEL HILO (El "Quién" lo va a hacer)
// Le pasamos nuestra tarea a un nuevo Hilo (Thread) y lo iniciamos con .start()
            new Thread(taskLogin).start(); // El hilo secundario comienza a trabajar aquí.

// 3. REACCIÓN AL ÉXITO (Volvemos a la Interfaz Gráfica)
// setOnSucceeded se ejecuta AUTOMÁTICAMENTE en el hilo principal (JavaFX Application Thread)
// SOLO cuando el método call() termina correctamente.
            taskLogin.setOnSucceeded(data -> {
                // Obtenemos el resultado que retornó el método call()
                int[] reponse = taskLogin.getValue();

                if (reponse == null) {
                    System.out.println("No esta el usuario");
                } else {
                    // Como estamos de vuelta en el hilo principal, es seguro interactuar con la UI (crear ventanas)
                    Stage stage = new Stage();
                    FXMLLoader loader = null;
                    String title = "";

                    // Verificamos el rol del usuario (asumiendo que reponse[1] guarda el tipo de rol)
                    switch (reponse[1]) {
                        case 1 -> {
                            title = "Administracion";
                            loader = new FXMLLoader(TiendaApplication.class.getResource("admin-view.fxml"));
                        }
                        case 2, 3 -> {
                            title = "Compras";
                            loader = new FXMLLoader(TiendaApplication.class.getResource("user-view.fxml"));
                            if(reponse[1] == 2){
                                // Lógica específica para rol 2 (por implementar)
                            } else if(reponse[1] == 3){
                                // Lógica específica para rol 3 (por implementar)
                            }
                        }
                    }

                    try {
                        Parent parent = loader.load();

                        // Si es un usuario normal o tipo 3, le pasamos su ID al controlador
                        if(reponse[1] == 2 || reponse[1] == 3){
                            UserController userController = loader.getController();
                            userController.setId(reponse[0]); // reponse[0] asume guardar el ID del usuario
                        }

                        // Preparamos y mostramos la nueva ventana
                        Scene scene = new Scene(parent);
                        stage.setScene(scene);
                        stage.setTitle(title);
                        stage.show();

                        // Cerramos la ventana de login actual
                        ((Stage)btnLogin.getScene().getWindow()).close();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });




        });
    }
}
