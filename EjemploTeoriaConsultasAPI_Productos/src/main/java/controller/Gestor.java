package controller;

import model.Producto;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Gestor {

    // Lista donde guardaremos los productos en la memoria de nuestro programa
    private List<Producto> productos;

    // Constructor que inicializa la lista vacía al crear el Gestor
    public Gestor() {
        productos = new ArrayList<>();
    }

    // ==========================================
    // MÉTODO 1: CONEXIÓN A LA API Y LECTURA MANUAL JSON
    // ==========================================
    public void obtenerProductosAPI() {
        HttpClient client = null;

        try {
            // 1. Creamos el "navegador" que hará la petición
            client = HttpClient.newHttpClient();

            // 2. Preparamos la petición indicando la URL exacta a la que queremos ir
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dummyjson.com/products"))
                    .build();

            // 3. Enviamos la petición y le decimos que queremos la respuesta como un String (texto)
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Transformamos el texto puro que devuelve internet en un objeto JSON manipulable
            JSONObject jsonObject = new JSONObject(response.body());

            // 5. El JSON padre tiene una clave llamada "products" que contiene una lista []. La extraemos.
            JSONArray productsArray = jsonObject.getJSONArray("products");

            // 6. Extraemos un producto concreto de esa lista (por ejemplo, el que está en la posición 0)
            JSONObject primerProductoJson = productsArray.getJSONObject(0);

            // 7. Leemos las claves de ese objeto JSON (title, sku, price)
            String tituloObtenido = primerProductoJson.getString("title");
            String skuObtenido = primerProductoJson.getString("sku");
            double precioObtenido = primerProductoJson.getDouble("price");

            // 8. Transformamos esos datos en un Objeto Java real de nuestra clase Producto
            Producto productoJava = new Producto(skuObtenido, tituloObtenido, precioObtenido);

            // 9. Lo guardamos en nuestra lista usando nuestro propio método
            agregarProducto(productoJava);

            System.out.println("¡Producto obtenido de la API con éxito!");

        } catch (IOException e) {
            // Error de conexión (ej: no hay internet)
            System.out.println("Error de red: " + e.getMessage());
        } catch (InterruptedException e) {
            // El proceso fue interrumpido a la mitad
            System.out.println("Conexión interrumpida.");
            Thread.currentThread().interrupt(); // Restauramos el hilo
        } finally {
            // Este bloque siempre se ejecuta, cerramos el cliente para no dejar procesos abiertos
            if (client != null) {
                client.close();
            }
        }
    }

    // ==========================================
    // MÉTODOS 2: OPERACIONES CON STREAMS Y LAMBDAS
    // ==========================================

    public void agregarProducto(Producto p) {
        // stream() abre el flujo de datos.
        // anyMatch() revisa uno a uno si la condición (misma id/código) es verdadera.
        // Devuelve 'true' en el momento que encuentra el primer repetido.
        boolean existe = productos.stream()
                .anyMatch(item -> item.getCodigo().equalsIgnoreCase(p.getCodigo()));

        if (existe) {
            System.out.println("Código ya usado, no se puede agregar el producto.");
        } else {
            productos.add(p);
            System.out.println("Producto '" + p.getTitulo() + "' agregado correctamente a la memoria.");
        }
    }

    public void asignarPrecios() {
        // filter(): Deja pasar por la tubería solo los productos cuyo precio sea menor a 0.
        // forEach(): A los productos que hayan pasado, les asigna un precio aleatorio positivo.
        productos.stream()
                .filter(item -> item.getPrecio() < 0)
                .forEach(item -> item.setPrecio((Math.random() * 100) + 1));
    }

    public void mostrarProductos() {
        // Recorre toda la lista y por cada elemento llama a su método mostrarDatos()
        System.out.println("--- LISTA DE PRODUCTOS ---");
        productos.forEach(Producto::mostrarDatos);
    }
}