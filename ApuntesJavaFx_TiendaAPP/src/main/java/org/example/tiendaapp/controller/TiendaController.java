package org.example.tiendaapp.controller;

import com.google.gson.Gson;
import javafx.beans.value.ChangeListener; // [ACTUALIZACIÓN]
import javafx.beans.value.ObservableValue; // [ACTUALIZACIÓN]
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader; // [ACTUALIZACIÓN]
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Parent; // [ACTUALIZACIÓN]
import javafx.scene.Scene; // [ACTUALIZACIÓN]
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality; // [ACTUALIZACIÓN PARA MODAL]
import javafx.stage.Stage; // [ACTUALIZACIÓN]
import org.example.tiendaapp.HelloApplication; // [ACTUALIZACIÓN]
import org.example.tiendaapp.data.DataSet; // [ACTUALIZACIÓN]
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
    @FXML private Button btnCarrito; // [ACTUALIZACIÓN]: Botón para abrir la modal del carrito

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

        // [ACTUALIZACIÓN]: LISTA FILTRADA
        /**
         * Inicializamos la lista filtrada pasándole la lista principal.
         * Actúa como una "capa" superior que decide qué elementos se muestran y cuáles no
         * basándose en una condición (predicado).
         */
        listFilter = new FilteredList<>(listProducts);
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

        // [ACTUALIZACIÓN]: CAMBIO DE ORIGEN DE DATOS
        /**
         * Antes enlazábamos directamente a 'listProducts'.
         * Ahora enlazábamos a 'listFilter' para que la tabla responda a las búsquedas del usuario.
         */
        tablaProductos.setItems(listFilter);
    }

    /**
     * actions(): Define el comportamiento de los botones y campos de texto.
     */
    private void actions() {

        // [ACTUALIZACIÓN]: FILTRO EN TIEMPO REAL
        /**
         * Escuchamos cada letra que el usuario escribe en el TextField.
         * El 'setPredicate' filtra la lista automáticamente buscando productos
         * cuyo título contenga el texto introducido (newValue).
         * Estas líneas crean un buscador dinámico. Mientras el usuario escribe (addListener), la lista se va
         * encogiendo o agrandando automáticamente (setPredicate) mostrando solo los productos cuyo nombre
         * coincida con la búsqueda, ignorando si se usan mayúsculas o minúsculas (toLowerCase).
         */
        editFiltro.promptTextProperty();
        editFiltro.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                listFilter.setPredicate(product -> product.getTitle().toLowerCase().contains(newValue.toLowerCase()));
            }
        /* Estas  líneas se encargan de la experiencia de usuario y de la lógica de búsqueda.

         * 1. editFiltro.promptTextProperty();
         * Esta línea, tal como está escrita (sin asignación), simplemente accede a la propiedad del
         * "texto de sugerencia". Sin embargo, normalmente se usa para establecer un mensaje dentro del cuadro
         * de texto que desaparece cuando el usuario empieza a escribir para indicar al usuario qué debe hacer
         * (normalmente escribirías editFiltro.setPromptText("Buscar producto...");).
         * En el código, llamar a .promptTextProperty() está obteniendo el "objeto" que gestiona ese
         * texto para enlazarlo a otra cosa.

         * 2. El Listener del textProperty()
         * Aquí es donde ocurre el filtrado en tiempo real:
         * textProperty(): vigila el contenido del TextField.
         * addListener: pone un "centinela" o vigilante. Cada vez que el texto cambie el vigilante saltará y
         ejecutará el código de dentro.
         * oldValue y newValue: El vigilante sabe qué había antes (oldValue) y qué acaba de escribir el usuario
         * (newValue).
         * listFilter.setPredicate: Filtro Inteligente:
         * - setPredicate:  -> Le da una instrucción a la FilteredList. Le dice: "A partir de ahora, solo deja
         * pasar a los productos que cumplan esta condición".
         * product -> ... -> Función lambda: "Coge cada producto de la lista uno por uno y comprueba lo siguiente...". */
        });

        // [ACTUALIZACIÓN]: LÓGICA DE COMPRA
        /**
         * Cuando pulsamos comprar:
         * 1. Obtenemos el producto seleccionado de la tabla.
         * 2. Lo añadimos al carrito global (DataSet).
         * 3. Reducimos el stock del objeto.
         * 4. Si el stock llega a 0, lo eliminamos de la lista principal.
         * 5. Refrescamos la tabla para ver los cambios.
         */
        btnCompra.setOnAction(event -> {
            Product product = tablaProductos.getSelectionModel().getSelectedItem();
            if (product != null) {
                DataSet.addCarrito(product);
                System.out.println("Productos en carrito: " + DataSet.getCarrito().size());

                product.setStock(product.getStock() - 1);
                tablaProductos.refresh();

                if (product.getStock() == 0) {
                    listProducts.remove(product);
                }
            }

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

        // [ACTUALIZACIÓN]: ABRIR VENTANA DEL CARRITO (MODAL)
        /**
         * 1. Creamos un nuevo Stage (escenario).
         * 2. Lo configuramos como MODAL (bloquea la ventana de la tienda hasta cerrar esta).
         * 3. Cargamos el FXML correspondiente.
         * 4. Usamos showAndWait() para pausar la lógica de la tienda.
         */
        btnCarrito.setOnAction(event -> {
            // 1. Creamos el nuevo escenario
            Stage stage = new Stage();

            // [IMPORTANTE]: Configuración de ventana MODAL
            // Esto impide que el usuario interactúe con la tienda hasta que cierre el carrito
            stage.initModality(javafx.stage.Modality.APPLICATION_MODAL);

            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("cart-view.fxml"));
            try {
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                stage.setTitle("Mi Carrito de la Compra");
                stage.showAndWait(); // showAndWait es clave para las modales
            } catch (IOException e) {
                System.out.println("No se pudo cargar la vista del carrito");
            }
        });
        /* Resumen del concepto:
        - Ventana Modal (APPLICATION_MODAL): -> Es una ventana que bloquea la ventana principal hasta que se cierra.
        Es muy útil para resúmenes de pago o carritos.
        - Centralización de Datos: -> Gracias a que usamos el DataSet con una lista static, el CartController no
        necesita que le "pasemos" los productos; él mismo sabe dónde ir a buscarlos al iniciarse.
        - showAndWait(): -> A diferencia de show(), este método pausa la ejecución del código del controlador principal
        hasta que la ventana secundaria se cierra, asegurando un flujo de usuario controlado. */

        // [ACTUALIZACIÓN]: VENTANA DE DETALLE
        /**
         * 1. Creamos un nuevo escenario (Stage).
         * 2. Cargamos el FXML de la vista de detalle.
         * 3. ¡IMPORTANTE!: Recuperamos la controladora de esa nueva ventana (getController).
         * 4. Le pasamos el producto seleccionado mediante un método (setProducto).
         */
        btnDetalle.setOnAction(event -> {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("detail-view.fxml"));
            try {
                Parent root = loader.load();
            /* Al hacer Parent root = loader.load();, se le dice a Java:
            "Lee el archivo XML, construye todos los botones y paneles que hay dentro, y dame el panel principal
            (la raíz) que los contiene a todos".
            Para mostrar una ventana nueva, JavaFX sigue siempre estos 4 pasos obligatorios, y el root es la pieza
            clave para conectar el diseño con la ventana real:
            Carga (loader.load()): El archivo .fxml se convierte en un objeto Java llamado root.
            Preparación del Controlador: Una vez cargado el root, podemos pedirle al loader que nos de el controlador
            (DetailController) para pasarle datos.
            Creación de la Escena (new Scene(root)): Aquí es donde usas el root. Una Scene (Escena) necesita saber qué
            contenido va a mostrar. Al pasarle el root, le estás dando todo el diseño del archivo FXML.
            Montaje en el Escenario (stage.setScene(scene)): Finalmente, pones esa escena en el Stage (la ventana con
            bordes, botones de cerrar, etc.). */

                // Comunicación entre controladores:
                DetailController detailController = loader.getController();
                detailController.setProducto(tablaProductos.getSelectionModel().getSelectedItem());

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Detalle del Producto");
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException("Error al cargar la vista de detalle: " + e.getMessage());
            }
        });

        btnCerrar.setOnAction(event -> {

            //1 - Creo stage
            Stage stage = new Stage();

            try {
                //2 - Cargo parte gráfica
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
                //3 - Creo escena
                Scene scene = new Scene(loader.load());

                //4 - Asocio stage a scene
                stage.setScene(scene);
                stage.setTitle("Tienda ThePower");
                stage.show();

                //5 - Cierro stage actual
                ((Stage)btnCerrar.getScene().getWindow()).close();
                // (voy desde uno de los elementos gráficos de la escena, a la escena, a la ventana, y al metodo close).

            } catch (IOException e){
                System.out.println("No se encuentra la ruta");
            }
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