package org.example.tiendaapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    // start es el método principal que construye la ventana una vez que JavaFX ha arrancado
    @Override
    public void start(Stage stage) throws IOException {
        // El FXMLLoader es el "traductor" que lee el archivo XML y crea los objetos Java
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("form-view.fxml"));

        // Se crea la Escena (el contenido de la ventana) y se le pasa la interfaz cargada
        Scene scene = new Scene(fxmlLoader.load());

        // Se asigna la escena al escenario principal (la ventana)
        stage.setScene(scene);
        stage.setTitle("Tienda The Power!"); // Título de la ventana superior

        // Finalmente, mostramos la ventana al usuario
        stage.show();
    }
}