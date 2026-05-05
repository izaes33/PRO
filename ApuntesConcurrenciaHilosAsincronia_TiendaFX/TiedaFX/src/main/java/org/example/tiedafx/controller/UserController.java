/**
 * APUNTES DE CONCURRENCIA:
 *
 * Este código muestra cómo manejar múltiples tareas asíncronas de manera simultánea.
 * En este caso, se crea un ecosistema de concurrencia dentr del método setId:
 *
 * 1. El "Qué" (Las dos Task):
 * En lugar de una, tenemos dos tareas:
 * - taskUser: Se encarga de ir a mi base de datos local para buscar un usuario por su ID.
 * - taskProducts: Se encarga de hacer una petición de red (HTTP GET) a internet
 *   (https://dummyjson.com/products), descargar un JSON y convertirlo en objetos
 *   de Java usando Gson.
 *
 * 2. El "Quién" (Los dos Thread):
 * Estoy contratando a dos trabajadores independientes al hacer:
 * - new Thread(taskUser).start()
 * - new Thread(taskProducts).start()
 *
 * La magia del paralelismo: Estos dos trabajadores hacen su trabajo al mismo tiempo.
 * Mientras uno busca en la base de datos, el otro está descargando cosas de internet.
 * Ninguno espera al otro, y mi hilo principal (el que dibuja la interfaz) sigue libre.
 *
 * 3. La Interacción (El reencuentro en la UI):
 * Cada tarea tiene su propio puente de regreso a la interfaz gráfica (setOnSucceeded).
 * - Cuando taskUser termina, le avisa al hilo principal de JavaFX para que actualice
 *   el saludo: textUser.setText(...).
 * - Cuando taskProducts termina (ya sea antes o después de la otra tarea),
 *   le avisa al hilo principal de JavaFX para que llene la lista visual:
 *   listaProductos.setItems(...).
 */package org.example.tiedafx.controller;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.example.tiedafx.dao.UserDAO;
import org.example.tiedafx.model.Product;
import org.example.tiedafx.model.ProductResponse;
import org.example.tiedafx.model.User;
import org.json.JSONArray; // Ojo: No lo estás usando en este fragmento
import org.json.JSONObject;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList; // Ojo: No lo estás usando en este fragmento
import java.util.List; // Ojo: No lo estás usando en este fragmento
import java.util.ResourceBundle;
import java.util.logging.Handler; // Ojo: No lo estás usando en este fragmento

public class UserController implements Initializable {
    @FXML private Button btnComprar;
    @FXML private Button btnSalir;
    @FXML private Button btnVaciar;
    @FXML private ListView<Product> listaProductos;
    private ObservableList<Product> listObserver;
    @FXML private Text textUser;
    @FXML private Text textoCarrito;

    private UserDAO userDAO;
    private Task<User> taskUser;
    private Task<ProductResponse> taskProducts;
    private User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instances();
        initGUI();
    }

    private void initGUI() {
        System.out.println("Inicializando la interfaz");
    }

    private void instances() {
        userDAO = new UserDAO();
        listObserver = FXCollections.observableArrayList();
    }

    // Este método es llamado desde el controlador de Login pasándole el ID
    public void setId(int id) {

        // ==========================================
        // TAREA 1: CARGAR DATOS DEL USUARIO (Base de datos)
        // ==========================================
        taskUser = new Task<User>() {
            @Override
            protected User call() throws Exception {
                // Trabajo pesado 1: Consulta a la base de datos en segundo plano
                return userDAO.getUser(id);
            }
        };

        // Asignamos la tarea a un nuevo Hilo y lo iniciamos inmediatamente
        new Thread(taskUser).start();

        // Qué hacer cuando el Hilo 1 termine con éxito (Se ejecuta en el hilo de la Interfaz Gráfica)
        taskUser.setOnSucceeded(data -> {
            user = taskUser.getValue(); // Extraemos el User resultante
            System.out.println(id);
            // Actualizamos la UI sin que la aplicación colapse
            textUser.setText("Bienvenido " + user.getName());
        });

        // ==========================================
        // TAREA 2: CARGAR PRODUCTOS (Petición HTTP a Internet)
        // ==========================================
        taskProducts = new Task<ProductResponse>() {
            @Override
            protected ProductResponse call() throws Exception {
                // Trabajo pesado 2: Petición de red en segundo plano
                // Esto es vital que esté en un Thread, ya que internet puede ser lento
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create("https://dummyjson.com/products"))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String body = response.body();

                // Parseo del JSON
                JSONObject object = new JSONObject(body);
                Gson gson = new Gson();
                // Convertimos el JSON a nuestro objeto ProductResponse y lo retornamos
                return gson.fromJson(object.toString(), ProductResponse.class);
            }
        };

        // Asignamos esta segunda tarea a OTRO Hilo y lo iniciamos
        // Nota: ¡Ambos hilos están trabajando en paralelo ahora mismo!
        new Thread(taskProducts).start();

        // Qué hacer cuando el Hilo 2 termine de descargar y parsear el JSON
        taskProducts.setOnSucceeded(data -> {
            // Extraemos los productos de la respuesta
            // Como estamos en el hilo principal (JavaFX Thread), podemos actualizar la ObservableList y el ListView
            listObserver = FXCollections.observableArrayList(taskProducts.getValue().getProducts());
            listaProductos.setItems(listObserver);
        });
    }
}