module org.example.tiendaapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires com.google.gson;
    requires java.net.http;
    requires static lombok;

/* EXPORTS: PERMITE QUE CUALQUIER OTRO MÓDULO QUE DENTRO DEL PAQUETE PUEDA IMPORTAR Y USAR LAS CLASES
PÚBLICAS.
OPENS: PERMITE ACCESO POR REFLEXIÓN PROFUNDA (DEEP REFLECTION) AL MÓDULO JAVAFX.FXML Y A LOS PAQUETES
Para que puedan actuar dentro de las clases controladoras y conectar los
elementos de las interfaces con el código. */
    opens org.example.tiendaapp to javafx.fxml;
    exports org.example.tiendaapp;

    exports org.example.tiendaapp.model;
    opens org.example.tiendaapp.model to javafx.fxml, org.json, com.google.gson, java.net.http;

    exports org.example.tiendaapp.controller;
    opens org.example.tiendaapp.controller to javafx.fxml, org.json, com.google.gson, java.net.http;

/* Módulo               ¿Para qué necesita entrar?
javafx.fxml             Para inyectar los componentes de la interfaz en las variables @FXML y enlazar los métodos
clic.org.json           Para para convertir los controladores o los datos que manejan a objetos JSON (o viceversa)
.com.google.gson        Al igual que Jackson, se usa para "mapear" los nombres de variables con las claves de un archivo JSON.
java.net.http           Este es el cliente HTTP nativo de Java. Incluye herramientas que transforman las respuestas de
                        una API web en objetos. */
}