**Comunicación Externa: APIs y JSON**

El software actual no vive aislado; consume servicios de internet (como pasarelas de pago o catálogos externos).

- **Peticiones HTTP Modernas:** Usamos HttpClient (introducido en Java 11) para conectarnos a un "Endpoint" (una URL que devuelve datos). Funciona de manera asíncrona o bloqueante, enviando una petición y esperando el "Body" de la respuesta.
- **El Wrapper (DTO):** Las APIs suelen enviar metadatos junto con los datos reales (ej. "total de resultados: 100", "skip: 0", y luego la lista de "productos"). No podemos mapear esto directamente a nuestra clase Producto. Necesitamos una clase "Sobre" (ProductResponse) que coincida milimétricamente con la estructura del JSON. **Generación automática:** Para facilitar la creación de las clases Java que albergarán los datos, se recomienda usar herramientas web como _quicktype.io_. Estas herramientas leen la estructura de un JSON pegado por el usuario y devuelven la clase Java completamente construida.
- **El papel de GSON:** Librerías como Gson o Jackson usan la técnica de la _Reflexión_ (Deep Reflection) para mirar dentro de tus clases Java en tiempo de ejecución, leer el nombre de tus variables privadas e inyectar automáticamente el valor que vino del texto JSON. Por eso es vital que tengas un constructor vacío (@NoArgsConstructor), para que GSON pueda instanciar el objeto antes de rellenarlo.  
  <br>

**1\. Peticiones HTTP y Tratamiento de JSON (APIs)**

Desde Java 11, el lenguaje incluye HttpClient para conectarse a internet de forma estándar y moderna, similar a un navegador o Postman.

**El ciclo de una petición consta de 4 pasos principales:**

- **Cliente (HttpClient):** El motor invisible que ejecuta la conexión.
- **Petición (HttpRequest):** El "sobre" donde se configura la URL de destino.
- **Envío:** Se ejecuta la orden de envío a internet (ej. client.send) y el programa espera.
- **Respuesta (HttpResponse):** Lo que devuelve el servidor, que normalmente contiene el cuerpo del mensaje en texto o JSON.

**Lectura manual de JSON con org.json:** Aunque es recomendable usar librerías automáticas como Jackson en la práctica , la lectura manual obliga a navegar por el texto como un diccionario de carpetas anidadas.

- **JSONObject:** Representa datos entre llaves {} y funciona como un diccionario clave-valor del cual se extrae información usando métodos como .getString("clave") o .getInt("clave").
- **JSONArray:** Representa listas de elementos encerradas entre corchetes \[\] de las cuales se extrae información usando .getJSONObject(posición).  
  <br>

**2\. Conexiones Web (Cliente HTTP)**

Para consumir una API, Java utiliza herramientas nativas para gestionar las comunicaciones por internet.

- **HttpClient:** Funciona como el "navegador web" interno de Java, siendo la herramienta encargada de realizar las conexiones a internet.
- **HttpRequest:** Representa la petición que se va a construir y enviar, definiendo la URL de destino y el método a utilizar (como GET).
- **URI:** Se utiliza para convertir el texto plano (String) de una URL en un objeto de dirección estructurada que el HttpRequest pueda procesar.
- **HttpResponse:** Es el objeto que contiene la respuesta completa del servidor tras enviar la petición. Incluye el código de estado (como 200 o 404), las cabeceras (headers) y el cuerpo (body) con los datos solicitados. Mediante BodyHandlers.ofString(), se indica que el cuerpo de la respuesta debe procesarse como texto String.  
  <br>

**3\. Procesamiento y Mapeo de JSON**

La información que devuelve la API llega en forma de texto, por lo que es necesario interpretarla y convertirla a objetos que Java entienda.

- **JSONObject (org.json):** Sirve para manejar objetos individuales que vienen anidados entre llaves {} en el JSON. Toma un texto plano y lo convierte en una estructura de datos consultable, similar a un diccionario.
- **JSONArray (org.json):** Permite manejar y extraer listas o arrays de elementos que vienen agrupados bajo una misma clave entre corchetes \[\].
- **Gson (Google):** Es la librería fundamental para convertir directamente fragmentos de JSON en objetos de Java, siempre que los nombres de las variables de la clase coincidan con las claves del JSON.

**Interfaz Serializable:** Al implementarla en una clase, se permite que sus objetos sean convertidos a secuencias de bytes. Esto es indispensable si los datos necesitan ser guardados en archivos, enviados a través de una red o almacenados en una sesión.  
<br>

**4\. Gestión de Errores y Excepciones**

El control de fallos es vital al depender de conexiones externas que pueden fallar.

- **Excepciones de Red:** Se captura IOException cuando hay problemas físicos o de servidor (falta de internet o servidor caído) e InterruptedException si el hilo de ejecución se interrumpe abruptamente mientras esperaba una respuesta.
- **throw vs throws:** La palabra throws se coloca en la firma (declaración) de un método para avisar que puede lanzar ciertas excepciones. En cambio, throw se utiliza dentro del bloque de código para lanzar explícitamente una instancia de error, como throw new Exception();.
- **Buenas prácticas:** En lugar de poner throws en la firma del método (lo cual obligaría a todas las capas superiores a lidiar con el error de red), es preferible capturar el error y lanzar una RuntimeException con throw. Esto mantiene el código limpio y permite cambiar de librería de red en el futuro sin tener que modificar las interfaces o firmas de otros métodos en la aplicación.
  <br>

---

## **flujo**

**│ FASE 1: PREPARACIÓN DE LA PETICIÓN │**

**\[ Texto Plano de URL \] 1. Convierte el texto en dirección estructurada.**

**▼**

**\[ URI \] 2. Construye la petición (destino y método, ej. GET).**

**▼**

**\[ HttpRequest \]**

**▼**

**│ FASE 2: CONEXIÓN Y RED (HTTP) │**

**│ 3. Toma la petición y realiza la conexión a internet.**

**▼**

**\[ HttpClient \]**

**│ \[!\] GESTIÓN DE ERRORES (try/catch)**

**│ • Captura: IOException / InterruptedException**

**│ • Acción: Lanza (throw) una RuntimeException**

**│ para mantener limpias las firmas (throws).**

**│ FASE 3: RECEPCIÓN DE DATOS │**

**│ 4. Si la conexión es exitosa, el servidor responde.**

**▼**

**\[ HttpResponse \] 5. BodyHandlers.ofString() extrae el cuerpo.**

**▼**

**\[ Cuerpo de la Respuesta \] (Texto plano / String)**

**│**

**│ FASE 4: PROCESAMIENTO JSON Y MAPEO │**

**│ 6. El texto llega a las herramientas de parseo.**

**▼**

**¿Cómo lo procesas?**

**┌────────┴────────────┐**

**\[ Opción A: Manual \] \[ Opción B: Automático \]**

**Usando org.json: Usando Gson de Google:**

**• JSONObject ({}) Mapea directamente el**

**• JSONArray (\[\]) JSON a Clases Java**

**(creadas con quicktype.io).**

**│ │**

**└────────┬─────────────┘**

**\[ Objetos Java \]**

**│**

**│ FASE 5: USO / PERSISTENCIA │**

**│ 7. Si necesitas guardar en disco o enviar por red.**

**▼**

**\[ Interfaz Serializable \]**

**(Convierte el objeto Java en una secuencia de bytes)**
