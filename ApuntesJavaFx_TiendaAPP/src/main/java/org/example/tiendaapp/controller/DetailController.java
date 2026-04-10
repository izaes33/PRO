package org.example.tiendaapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.example.tiendaapp.model.Product;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * CONTROLADOR DE DETALLE:
 * Esta clase gestiona la vista de pormenores de un producto.
 * A diferencia de los otros controladores, su función principal no es cargar datos de una API,
 * sino "escuchar" y mostrar lo que el controlador de la tienda le envíe.
 */
public class DetailController implements Initializable {

    /**
     * COMPONENTES DE LA INTERFAZ:
     * Usamos Labels (etiquetas) porque en esta ventana el usuario solo consulta información,
     * no suele editarla (para eso usaríamos TextFields).
     */
    @FXML
    private Label textoPrecio, textoDesc, textoNombre;

    /**
     * MÉTODO INITIALIZE:
     * Obligatorio por la interfaz Initializable.
     * En este controlador suele estar vacío porque los datos no se conocen al "nacer" la ventana,
     * sino que llegan un instante después a través del método setProducto.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * MÉTODO DE COMUNICACIÓN (setProducto):
     * Este método es el "puente" o "buzón" de la clase.
     * Se llama desde TiendaController justo después de cargar el FXML de detalle pero antes de mostrarlo.
     * * @param product El objeto completo con los datos que el usuario seleccionó en la tabla.
     */
    public void setProducto(Product product){
        // 1. Asignamos la descripción larga al label correspondiente
        this.textoDesc.setText(product.getDescription());

        // 2. Asignamos el título del producto
        this.textoNombre.setText(product.getTitle());

        /**
         * 3. GESTIÓN DE TIPOS DE DATOS:
         * Los Labels solo aceptan Strings (texto). Como el precio en el modelo Product
         * suele ser un valor numérico, debemos convertirlo usando String.valueOf().
         */
        String precio = String.valueOf(product.getPrice());
        this.textoPrecio.setText(precio);
    }
}