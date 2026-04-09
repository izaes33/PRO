module org.example.tiendaapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.net.http;
    requires com.google.gson;


    opens org.example.tiendaapp to javafx.fxml;
    exports org.example.tiendaapp;

    exports org.example.tiendaapp.model;
    opens org.example.tiendaapp.model to javafx.fxml;

    exports org.example.tiendaapp.controller;
    opens org.example.tiendaapp.controller to javafx.fxml;
}