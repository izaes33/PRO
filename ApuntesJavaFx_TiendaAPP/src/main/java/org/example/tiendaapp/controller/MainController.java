package org.example.tiendaapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // Equivalente a document.getElementById en JavaScript
    @FXML private Button botonSaludar;
    @FXML private TextField editNombre;
    @FXML private Text textoSaludo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // todos los codigos que  yo ponga aqui, se ejecuta nada mas cargar la parte fxml

        // Configuración de evento simple. Al pulsar el botón...
        botonSaludar.setOnAction(event -> {
            // Obtenemos el texto tecleado por el usuario
            String texto = editNombre.getText();

            if (texto.isEmpty()){
                textoSaludo.setText("No hay nadie a quien saludar");
            } else {
                // Modificamos el nodo texto inferior
                textoSaludo.setText("Enhorabuena "+texto+" has completado la app JAVA FX");
            }
        });
    }
}