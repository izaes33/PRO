package controller;

import model.Clasificacion;
import model.Liga;
import model.Equipo;
import model.Team;

import java.io.IOException;


import com.google.gson.Gson; // Importamos la clase Gson desde la librería de Google.
// Gson sirve para convertir JSON en objetos Java.

import org.json.JSONArray;/* Importamos JSONArray de la librería org.json.
Sirve para manejar arrays dentro de un JSON.
Ejemplo: cuando la API devuelve "leagues": [ {...}, {...}, {...} ] */

import org.json.JSONObject; /* Importamos JSONObject de la librería org.json.
Sirve para manejar objetos individuales dentro de un JSON.
Ejemplo: { "idLeague": "1234", "strLeague": "La Liga" } */


import java.net.URI; /* URI representa una dirección web estructurada.
Se usa para convertir el String de la URL en un objeto válido
que HttpRequest pueda utilizar. */

import java.net.http.HttpClient; // HttpClient Es la clase que realiza la conexión HTTP.

import java.net.http.HttpRequest; // HttpRequest Representa la petición que vas a enviar: URL; método (GET, POST, etc.); cabeceras

import java.net.http.HttpResponse; /* HttpResponse representa la respuesta que devuelve el servidor.
Contiene: código de estado (200, 404, etc.); cuerpo (body); cabeceras */



public class APIController {

    // Variable privada que almacena la URL base de la API (la parte fija de la dirección).
    private String urlBase = "https://www.thesportsdb.com/api/v1/json/123/";

    public void obtenerLigas() {

        String urlLigas = urlBase + "all_leagues.php"; /* Dirección final a la que haremos la petición.
        (Construimos la URL concatenando la URL base y el endpoint "all_leagues.php") */

        try {

            Gson gson = new Gson();
            // Creamos una instancia de Gson. (la librería que convierte JSON en objetos Java y viceversa).

            HttpClient client = HttpClient.newHttpClient();  /* 'HttpClient' es el "navegador web" interno de Java.
            (Este objeto es la herramienta que se encarga de realizar conexiones a internet. */

            // Construimos la petición HTTP, en la que HttpRequest define: a qué URL vamos y qué tipo de petición hacemos (GET en este caso).
            HttpRequest request = HttpRequest          // Dentro:
                    .newBuilder()                         //- Creamos un builder para configurar la petición
                    .uri(URI.create(urlLigas))            //- Indicamos la URL destino
                    .GET()                                //- Especificamos que es una petición GET (solo obtener datos)
                    .build();                             //- Construimos la petición final

            HttpResponse<String> response = // Enviamos la petición al servidor.
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            /* client.send(...) hace la conexión real con la API.
            BodyHandlers.ofString() indica que queremos la respuesta como String.
            La API responde con un texto en formato JSON. */
            JSONObject objectLigas = new JSONObject(response.body());
            // Creamos un JSONObject a partir del body (contenido) de la respuesta.
            JSONArray arrayLigas = objectLigas.getJSONArray("leagues");
            /* Dentro del JSON recibido hay una clave llamada "leagues" que contiene un array (lista) de ligas.
            Extraemos ese array y lo guardamos en una variable de tipo JSONArray. */

            for (int i = 0; i < arrayLigas.length(); i++) {
                // Recorremos el array desde la posición 0 hasta el final.

                JSONObject ligaJSON = arrayLigas.getJSONObject(i);
                // Obtenemos cada elemento JSONObject individualmente (que representa una liga).
                Liga liga = gson.fromJson(ligaJSON.toString(), Liga.class);
                /* Convertimos ese JSON en un objeto Java de tipo Liga:
                (Tomamos el JSON del equipo (ligaJSON.toString()) y le decimos a Gson:
                "Toma este texto y conviértelo en un objeto de mi clase 'Liga'".
                (Para que esto funcione, los nombres de las variables en tu clase 'Liga'
                deben coincidir con las claves del JSON)). */

                System.out.println(liga); // Imprimimos el objeto Liga en consola.
                /* Para que esto sea útil, la clase Liga debería tener
                el método toString() sobrescrito. */

            }

        } catch (IOException e) { /* Esta excepción ocurre si hay un problema de red:
            (No hay internet; El servidor no responde; Error de conexión) */
            throw new RuntimeException(e); /*Convertimos la excepción en RuntimeException
            // para no tener que declararla en la firma del método. */

        } catch (InterruptedException e) {
            /* Esta excepción ocurre si el hilo que está ejecutando
            la petición es interrumpido mientras espera la respuesta. */
            throw new RuntimeException(e);
        }
        /* Poner los throws en la firma es correcto si quieres que quien llame a tu método obligatoriamente maneje el error.
        No ponerlos y lanzar una RuntimeException es mejor si quieres delegar la gestión del error a una capa superior
        , manteniendo el código de APIController más limpio.
        (Imagina que más adelante creas una interfaz ILigaController. Si en la implementación APIController pones
        throws IOException, estás obligando a que la interfaz también diga throws IOException. Si luego decides cambiar
        de librería de red (ej. de HttpClient a Retrofit), podrías tener que cambiar todas las firmas de los métodos en todas partes). */
        /* Característica-->->->throw-----------------------------------------------throws
                Propósito	    Se usa para lanzar una excepción explícitamente.	Se usa para declarar que un método puede lanzar una excepción.
                Ubicación	    Dentro del cuerpo de un método o bloque de código.	En la firma (declaración) del método.
                Cantidad	    Se puede lanzar una instancia de una excepción.	    Se pueden declarar varias excepciones (separadas por comas).
                Sintaxis	    throw new Exception();	                            void metodo() throws Exception {} */
    }



    public void obtenerClasificacion(String id) {
    // Este 'id' probablemente corresponda al identificador de una liga o torneo específico.

        String urlClasificacion = urlBase + "lookuptable.php?l=" + id; // 1. CONSTRUCCIÓN DE LA URL:

        try {

            // 2. PREPARACIÓN DE HERRAMIENTAS
            Gson gson = new Gson();
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(urlClasificacion))
                    .GET()
                    .build();

            // 3. EJECUCIÓN DE LA PETICIÓN
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. PROCESAMIENTO DEL JSON
            JSONObject objectClasificacion = new JSONObject(response.body());

            JSONArray arrayEquipos = objectClasificacion.getJSONArray("table");

            // 5. BUCLE PARA RECORRER LOS DATOS
            for (int i = 0; i < arrayEquipos.length(); i++) {

                JSONObject equipoJSON = arrayEquipos.getJSONObject(i);
                Equipo equipo = gson.fromJson(equipoJSON.toString(), Equipo.class);

                // 6. IMPRESIÓN POR CONSOLA

                System.out.printf("%s - %s - %s - %s - %s%n",
                        equipo.getIntRank(),   // Posición en la tabla
                        equipo.getStrTeam(),   // Nombre del equipo
                        equipo.getIntWin(),    // Partidos ganados
                        equipo.getIntDraw(),   // Partidos empatados
                        equipo.getIntLoss());  // Partidos perdidos
            }

            // 7. MANEJO DE ERRORES (Excepciones)
            // Si hay un error de entrada/salida (ej. no hay internet o la URL no existe)...
        } catch (IOException e) {
            // ...se lanza un error de ejecución que detiene el programa y muestra qué falló.
            throw new RuntimeException(e);

            // Si la conexión se interrumpe abruptamente en mitad del proceso...
        } catch (InterruptedException e) {
            // ...también lanzamos el error para avisar al sistema.
            throw new RuntimeException(e);
        }
    }

    public void obtenerClasificacionCompleta(String id){
        String urlClasificacion = urlBase + "lookuptable.php?l=" + id;
        try {
            Gson gson = new Gson();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(urlClasificacion))
                    .GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject objectClasificacion = new JSONObject(response.body());
            Clasificacion clasificacion = gson.fromJson(objectClasificacion.toString(), Clasificacion.class);

            for (int i = 0; i < clasificacion.getTable().length; i++) {
                Team team = clasificacion.getTable()[i];
                System.out.printf("%s - %s - %s - %s - %s%n",
                        team.getIntRank(),
                        team.getStrTeam(),
                        team.getIntWin(),
                        team.getIntDraw(),
                        team.getIntLoss());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
