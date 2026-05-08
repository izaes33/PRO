**Interfaces Gráficas (GUI) con JavaFX**

**1\. Arquitectura Base y Configuración**

El desarrollo en JavaFX sigue el principio de **Separación de Concernimientos (Separation of Concerns)**, apoyado en el patrón MVC (Modelo-Vista-Controlador).

JavaFX ha sustituido a AWT y Swing para las aplicaciones de escritorio en Java. Su arquitectura se divide en:

- **Estructura Base:** El Stage actúa como el marco físico de la ventana, mientras que la Scene contiene todos los elementos gráficos dentro de él.
- **Nodos (Nodes):** Pueden ser finales (elementos renderizados como Botones, TextFields, Tablas) o contenedores de layout (VBox para vertical, HBox para horizontal, BorderPane por puntos cardinales o GridPane en formato tabla).
- **Controladores y Vista:** La vista gráfica se diseña en archivos estáticos .fxml (usualmente en la carpeta resources). La lógica se programa en un Controlador .java, donde los elementos de la interfaz se inyectan empleando la anotación @FXML seguida de su variable asociada por el ID.
- **Eventos:** Para dotar de vida a la interfaz, se enlazan "escuchadores" a los nodos, siendo muy habitual usar elemento.setOnAction() junto a funciones lambda para manejar clics y acciones. Es recomendable que el controlador implemente Initializable para configurar elementos visuales nada más cargar la escena.
- **Configuración:** Al ser modular, es vital configurar el archivo module-info.java para abrir y requerir accesos a las librerías correctas (como javafx.fxml). Se debe otorgar acceso público y de compilación a otros módulos usando exports. Se debe permitir el acceso por reflexión profunda (Deep Reflection) usando opens específicamente al módulo javafx.fxml para que JavaFX pueda enlazar las variables @FXML con el código.  
  <br>

**2\. El Flujo de Ejecución (Ciclo de Vida)**

El ciclo de vida de una aplicación JavaFX sigue un orden estricto:

- **Inicio:** El método universal entra por la clase Launcher que ejecuta Application.launch() para despertar el motor gráfico.
- **Preparación FXML:** Se llama al método start(Stage) y entra en juego el FXMLLoader, que actúa como traductor leyendo el archivo .fxml.
- **Construcción en Memoria:** JavaFX crea los objetos visuales (botones, campos de texto) en la memoria RAM.
- **Inyección del Controlador:** JavaFX lee la etiqueta fx:controller, instancia el controlador correspondiente y enlaza los objetos visuales a las variables marcadas con @FXML. Un fallo aquí produce un NullPointerException.
- **Método initialize():** Una vez conectados los elementos, se ejecuta automáticamente el método initialize(). Es buena práctica dividirlo en: instances() (objetos lógicos), initGUI() (configuración visual) y actions() (eventos de botones).
- **Visualización:** Se empaqueta la Escena (Scene) en el Escenario (Stage) y se ejecuta stage.show(), mostrando la ventana al usuario.
- **Bucle de Eventos:** El programa entra en un ciclo de espera, escuchando clics o interacciones.
- **Cierre:** El motor limpia la memoria y el proceso termina cuando el usuario cierra la ventana o se llama a stage.close().  
  <br>

**3\. Navegación y Ventanas**

Para entender la navegación, se utiliza la metáfora del teatro: el **Stage** es la ventana física del sistema operativo , y la **Scene** es el contenido (el FXML) que va dentro.

- **Cambiar de Escena (Navegación normal):** Se reemplaza el contenido sin abrir una ventana nueva. Se usa stage.setScene(nuevaEscena) obteniendo el Stage actual mediante ((Node) event.getSource()).getScene().getWindow().
- **Abrir Ventana Extra:** Se instancia un nuevo Stage (new Stage()) junto a show(), permitiendo tener dos ventanas libres e independientes.
- **Ventanas Modales:** Se usan para alertas o diálogos que bloquean la aplicación.
  - Se configuran con initModality(Modality.APPLICATION_MODAL) para bloquear todo, o initOwner() para vincularla a una ventana padre.
  - Se abren usando showAndWait(), lo que detiene la ejecución del código en ese controlador hasta que el usuario responda o cierre la ventana.

**Paso de Datos entre Pantallas:**

Para pasar información (como un usuario logueado) al cambiar de pantalla, existen dos enfoques:

- **Paso entre controladores:** Separar la carga del FXMLLoader. Se llama a loader.load(), luego a loader.getController() para obtener el controlador de destino, y se le pasan los datos mediante un método "puente" (ej. setDatos()) antes de mostrar la escena.
- **Singleton / Data Holder:** Crear una clase estática (ej. SessionData) para almacenar datos globalmente y compartirlos fácilmente entre muchas ventanas.  
  <br>

**4\. Componentes y Eventos**

- **Eventos Directos:** Se utiliza setOnAction con funciones lambda para ejecutar código al hacer clic.
- **Eventos Compartidos:** Se implementa EventHandler. El método event.getSource() es vital para identificar exactamente qué elemento gráfico provocó la acción.
- **Modelos Especiales:**
  - Spinner: Requiere un SpinnerValueFactory para definir sus reglas de conteo.
  - Botones de Radio: Requieren un ToggleGroup para funcionar de manera excluyente.
  - Listas desplegables (ChoiceBox): Se necesita llamar a getSelectionModel().getSelectedItem() para obtener el valor.
  - TableView: Utiliza PropertyValueFactory para indicarle a las columnas qué atributo del modelo deben leer.  
    <br>

**5\. Gestión y Modelado de Datos**

El sistema se organiza separando la persistencia, los moldes de negocio y el transporte.

**Repositorio Central (DataSet)**

- Actúa como una base de datos estática en memoria para compartir información entre ventanas.
- Usa colecciones reactivas como ObservableList, que actualizan la interfaz visual automáticamente cuando se modifican los datos.
- Aprovecha la programación funcional (Streams) para filtrar y buscar datos rápidamente.

**Modelos de Negocio (Product)**

- Son clases POJO (Plain Old Java Object) que definen la estructura real de los datos.
- Suelen usar la anotación @Data de Lombok para generar Getters y Setters automáticamente, aunque se advierte tener cuidado de excluir toString o equalsAndHashCode si se usan ORMs.
- Mejoran la integridad usando **Enums** para forzar valores válidos y **Composición de Objetos** para evitar clases gigantes.

**Patrón DTO / Wrapper (ProductResponse)**

- Se utilizan para recibir respuestas complejas de APIs.
- Son "sobres" que contienen metadatos (como saltos o límites) y la lista real de objetos anidada.
- Librerías como GSON utilizan estas clases "Wrapper" para mapear y deserializar toda la estructura del JSON web antes de extraer los datos puros hacia la interfaz.  
  <br>

**6\. Ejemplo de Orquestación de Controladores**

Para unir toda esta teoría, la aplicación se divide por roles:

- **LoginController (Orquestador):** Valida credenciales contra el DataSet y decide qué vista cargar. Si es administrador, abre el FormController; si es usuario estándar, abre el TiendaController.
- **FormController (Administrador):** Permite crear usuarios e inyectarlos al DataSet reactivo.
- **TiendaController (Consumidor):** No consulta el DataSet interno, sino que extrae datos de una API externa transformándolos en objetos para mostrarlos en tablas.
- **MainController (Laboratorio):** Utilizado para probar principios básicos de eventos y nodos gráficos.
  Rendered
  Interfaces Gráficas (GUI) con JavaFX
