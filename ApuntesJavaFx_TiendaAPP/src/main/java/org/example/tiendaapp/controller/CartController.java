package org.example.tiendaapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.example.tiendaapp.data.DataSet;
import org.example.tiendaapp.model.Product;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * CONTROLADOR DEL CARRITO (Ventana Modal):
 * Esta clase se encarga de mostrar al usuario los productos que ha ido
 * añadiendo desde la tienda y calcular cuánto dinero suma el total.
 */
public class CartController implements Initializable {

    /**
     * ELEMENTOS DE LA INTERFAZ:
     * - ListView: Es un componente de JavaFX diseñado para mostrar listas verticales de objetos.
     * - Label: Lo usamos para mostrar el precio total acumulado.
     */
    @FXML private ListView<Product> listCarrito;
    @FXML private Label labelTotal;

    /**
     * MÉTODO INITIALIZE:
     * Al ser una ventana modal que se abre bajo demanda, este método se ejecuta
     * en cuanto cargamos el FXML. Es el momento ideal para rellenar la lista.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 1. CONEXIÓN DE DATOS:
        /**
         * Accedemos al DataSet (nuestra "base de datos" estática) y obtenemos
         * la lista de productos del carrito. Al usar setItems(), el ListView
         * mostrará automáticamente los nombres de los productos.
         */
        listCarrito.setItems(DataSet.getCarrito());

        // 2. LÓGICA DE CÁLCULO:
        /**
         * Llamamos a un método propio para que sume los precios de todo lo
         * que hay en la lista y actualice la etiqueta del total.
         */
        calcularTotal();
    }

    /**
     * calcularTotal(): Recorre la lista de productos del carrito y suma sus precios.
     */
    private void calcularTotal() {
        double total = 0;

        /**
         * Bucle "for-each":
         * Por cada 'Product' (p) que encontremos en la lista del carrito...
         */
        for (Product p : DataSet.getCarrito()) {
            // Vamos acumulando el precio en la variable total
            total += p.getPrice();
        }

        /**
         * FORMATEO DE TEXTO:
         * Usamos String.format para que el número solo tenga 2 decimales y el símbolo €.
         * "%.2f" significa: número decimal (float/double) con 2 cifras decimales.
         */
        labelTotal.setText(String.format("Total: %.2f €", total));
    }
}

/*
* - ListView vs TableView:    -> En el carrito usamos un ListView porque solo queremos listar los nombres de los productos
* uno tras otro de forma sencilla, a diferencia de la TableView de la tienda que tiene columnas para stock, precio, etc.
* - Acceso Estático:    -> Fíjate que no necesitamos que nadie nos "pase" la lista. Como en DataSet la definimos
* como static, el CartController simplemente pregunta: "Oye DataSet, dame lo que haya en el carrito" y lo pinta.
* - Formateo de Moneda:     -> Es muy importante usar String.format o DecimalFormat para evitar que salgan precios
* con 10 decimales (como 19.99000000002 €) debido a la precisión de los números en Java. */