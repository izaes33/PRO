package org.example.tiendaapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * CONTROLADOR PRINCIPAL (Laboratorio):
 * Este controlador demuestra el funcionamiento más básico de JavaFX:
 * Leer una entrada de texto y actualizar una etiqueta al pulsar un botón.
 */
public class MainController implements Initializable {

    /**
     * INYECCIÓN FXML:
     * Equivalente al 'document.getElementById' de JavaScript o 'findViewById' de Android.
     * Conecta el ID definido en SceneBuilder con estas variables.
     */
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
    private void actions() {
        /**
         * EVENTO SIMPLE (Lambda):
         * 'event -> { ... }' es un atajo para definir qué pasa al hacer clic.
         */
        botonSaludar.setOnAction(event -> {

            // 1. Obtenemos el texto que el usuario escribió en el cuadro
            String texto = editNombre.getText();

            // 2. Validación básica de datos
            if (texto.isEmpty()){
                // Modificamos el nodo de texto para dar feedback
                textoSaludo.setText("No hay nadie a quien saludar");
            } else {
                /**
                 * MANIPULACIÓN DINÁMICA:
                 * Cambiamos el contenido del elemento visual 'textoSaludo' en tiempo real.
                 */
                textoSaludo.setText("Enhorabuena " + texto + " has completado la app JAVA FX");
            }
        });
    }
}