package org.example.tiendaapp.controller;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.tiendaapp.model.Product;
import org.example.tiendaapp.model.ProductResponse;

/**
 * CONTROLADOR DE LA TIENDA:
 * Este controlador gestiona la visualización de productos obtenidos de una API externa.
 * Implementa Initializable para preparar la tabla y los datos al arrancar la vista.
 */
public class TiendaController implements Initializable {

    // ELEMENTOS DE LA INTERFAZ (Inyectados desde el FXML)
    @FXML private Button btnCerrar;
    @FXML private Button btnCompra;
    @FXML private Button btnDetalle;

    /**
     * COLUMNAS DE LA TABLA:
     * Cada columna necesita saber qué tipo de objeto maneja (Product)
     * y qué tipo de dato mostrará (String o Number).
     */
    @FXML private TableColumn<Product, String> columnaNombre;
    @FXML private TableColumn<Product, Number> columnaPrecio;
    @FXML private TableColumn<Product, Number> columnaStock;

    @FXML private TextField editFiltro;

    /**
     * LA TABLA (TableView):
     * Es el componente principal de esta vista. Visualiza una lista de productos.
     * (Es el contenedor principal que dibujará la lista de productos).
     */
    @FXML private TableView<Product> tablaProductos;

    /* VARIABLES LÓGICAS (Engranajes internos) */

    /**
     * LISTA OBSERVABLE DE PRODUCTOS:
     * Aquí almacenaremos los productos que traigamos de Internet.
     * Al ser Observable, ésta se enterará automáticamente cuando los productos terminen de descargarse de Internet
     * y cualquier cambio aquí se reflejará en la tabla automáticamente.
     */
    private ObservableList<Product> listProducts;

    /**
     * LISTA FILTRADA (Wrapper):
     * Esta lista "envuelve" a la anterior. Permite aplicar filtros de búsqueda
     * (por ejemplo, buscar por nombre) sin borrar los datos originales.
     */
    private FilteredList<Product> listFilter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Estructura organizada de arranque
        instances();
        initGUI();
        loadJSONProducts(); // Carga de datos inicial
        actions();
    }

    /**
     * instances(): Inicializa los contenedores de datos.
     */
    private void instances() {
// Inicializamos la lista que contendrá los productos de la API
        listProducts = FXCollections.observableArrayList();
    }

    /**
     * initGUI(): Configura la conexión entre la tabla y el modelo de datos.
     */
    private void initGUI() {
        /**
         * PROPERTY VALUE FACTORY (El Pegamento):
         * Este método conecta la columna visual con el atributo del objeto Java.
         * "title" debe coincidir exactamente con el nombre de la variable en la clase Product.
         */
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnaStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        // Enlazamos la tabla con nuestra lista observable.
        tablaProductos.setItems(listProducts);
    }

    /**
     * actions(): Define el comportamiento de los botones y campos de texto.
     */
    private void actions() {
        // Sugerencia visual para el campo de búsqueda
        editFiltro.promptTextProperty();

        btnCompra.setOnAction(event -> {
            /**
             * NOTA SOBRE HILOS (Threads):
             * Las peticiones a Internet pueden "congelar" la interfaz si tardan mucho.
             * Aunque aquí se hace de forma directa, lo ideal es usar un Task o Thread
             * para que la ventana no se quede bloqueada mientras descarga.
             */
            /*
            loadJSONProducts();
            Task task = new Task() {
                @Override
                protected Object call() throws Exception {
                    return null;
                }
            };
            Thread thread = new Thread(task);
            thread.run();
            */
        });
    }

    /**
     * loadJSONProducts(): El motor de conexión.
     * Se conecta a una URL, descarga un JSON y lo convierte en objetos Java.
     */
    private void loadJSONProducts() {
        // 1. Creamos el cliente que hará la petición
        HttpClient client = HttpClient.newHttpClient();

        // 2. Construimos la petición (Request) indicando la dirección (URL)
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://dummyjson.com/products"))
                .GET()
                .build();

        try {
            // 3. Enviamos la petición y esperamos la respuesta (Response) como String
            HttpResponse<String> reponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = reponse.body();

            /**
             * DESERIALIZACIÓN CON GSON:
             * GSON es una librería que convierte el texto (JSON) en objetos Java automáticamente.
             * * - body: El texto bruto que viene de Internet.
             * - ProductResponse.class: El molde o clase que debe usar GSON para organizar esos datos.
             */
            Gson gson = new Gson();
            ProductResponse responseProduct = gson.fromJson(body, ProductResponse.class);

            // 4. Actualizamos la lista. ¡La tabla se refresca sola al ser Observable!
            listProducts.setAll(responseProduct.getProducts());

        } catch (IOException e) {
            // Error de conexión o entrada/salida
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            // Error si el proceso es interrumpido
            throw new RuntimeException(e);
        }
    }
}