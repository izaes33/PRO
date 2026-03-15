package org.example.tiendaapp;

import javafx.application.Application;

/*
 * Usamos una clase separada del Application original para arrancar el proyecto.
 * Esto evita ciertos errores de configuración al compilar proyectos JavaFX modernos
 * que no usan módulos de forma estricta.
 */
public class Launcher {
    public static void main(String[] args) {
        // Llama al motor de JavaFX y le dice qué clase Application arrancar
        Application.launch(HelloApplication.class, args);
    }
}