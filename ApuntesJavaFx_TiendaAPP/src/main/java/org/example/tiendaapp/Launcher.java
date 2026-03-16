package org.example.tiendaapp;

import javafx.application.Application;

/*
 * Usamos una clase separada del Application original para arrancar el proyecto.
 * Esto evita ciertos errores de configuración al compilar proyectos JavaFX modernos
 * que no usan módulos de forma estricta.
 * (La clase Launcher es un 'puente'. Engaña a Java para que arranque la aplicación
 * como si fuera un programa normal de consola, evitando que el sistema se bloquee
 * buscando configuraciones de módulos complejas que a veces fallan al empaquetar
 * el proyecto).
 */
public class Launcher {
    public static void main(String[] args) {
        // Llama al motor de JavaFX y le dice qué clase Application arrancar
        Application.launch(HelloApplication.class, args);
    }
}