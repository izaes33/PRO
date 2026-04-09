package org.example.tiendaapp.model;

import java.util.List;

/**
 * PRODUCT RESPONSE (Capa de transporte):
 * La API "DummyJSON" no devuelve los productos directamente en un array [ ],
 * sino que los mete dentro de un objeto { } con metadatos.
 * * Esta clase sirve como envoltorio para que GSON pueda mapear la respuesta completa.
 */
@lombok.Data
public class ProductResponse {

    /**
     * LA LISTA REAL:
     * Aquí es donde GSON guardará la lista de objetos 'Product' que
     * luego el TiendaController extraerá para su tabla.
     */
    private List<Product> products;

    // Metadatos de paginación (útiles para saber cuántos productos hay en total)
    private long total;
    private long skip;
    private long limit;
}