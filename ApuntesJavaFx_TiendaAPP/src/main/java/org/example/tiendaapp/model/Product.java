package org.example.tiendaapp.model;

import java.io.IOException;
import java.util.List;

/**
 * CLASE PRODUCTO (El Molde Principal):
 * Esta clase representa la estructura de un producto tal cual viene de la API.
 * * @lombok.Data:
 * Esta anotación es fundamental. Le dice a la librería Lombok que genere por nosotros
 * todos los Getters, Setters, el método toString() y el Constructor.
 * ¡Ahorramos cientos de líneas de código repetitivo!
 */
@lombok.Data
public class Product {
    // Atributos básicos (Mapeados directamente desde las claves del JSON)
    private long id;
    private String title;
    private String description;

    /**
     * TIPOS PERSONALIZADOS (Enums):
     * No usamos un String para la categoría, sino un Enum (Category).
     * Esto evita errores de escritura y asegura que el producto solo pueda
     * pertenecer a una categoría válida.
     */
    private Category category;

    private double price;
    private double discountPercentage;
    private double rating;
    private long stock;

    // Listas: Para cuando el JSON trae un array de elementos (ej: ["tag1", "tag2"])
    private List<String> tags;
    private String brand;
    private String sku;
    private long weight;

    /**
     * COMPOSICIÓN (Clases Anidadas):
     * Un producto tiene 'Dimensiones'. En lugar de poner width, height y depth aquí,
     * creamos una clase específica 'Dimensions' para organizar mejor el código.
     */
    private Dimensions dimensions;

    private String warrantyInformation;
    private String shippingInformation;
    private AvailabilityStatus availabilityStatus;

    /**
     * RELACIONES:
     * Un producto puede tener muchas reseñas. Usamos una lista de la clase 'Review'.
     */
    private List<Review> reviews;

    private ReturnPolicy returnPolicy;
    private long minimumOrderQuantity;
    private Meta meta;

    // Imágenes: Guardamos las URLs que vienen de la API
    private List<String> images;
    private String thumbnail;
}

/**
 * ENUM: AvailabilityStatus
 * Define los estados posibles de stock.
 */
enum AvailabilityStatus {
    IN_STOCK, LOW_STOCK;

    /**
     * toValue(): Convierte el valor del Enum a un String amigable para el JSON o la UI.
     */
    public String toValue() {
        switch (this) {
            case IN_STOCK: return "In Stock";
            case LOW_STOCK: return "Low Stock";
        }
        return null;
    }

    /**
     * forValue(): El proceso inverso. Recibe un String de la API y lo
     * convierte en una constante de nuestro Enum.
     */
    public static AvailabilityStatus forValue(String value) throws IOException {
        if (value.equals("In Stock")) return IN_STOCK;
        if (value.equals("Low Stock")) return LOW_STOCK;
        throw new IOException("No se reconoce el estado de disponibilidad: " + value);
    }
}

/**
 * ENUM: Category
 * Clasificación cerrada de los tipos de productos que maneja la tienda.
 */
enum Category {
    BEAUTY, FRAGRANCES, FURNITURE, GROCERIES;

    public String toValue() {
        switch (this) {
            case BEAUTY: return "beauty";
            case FRAGRANCES: return "fragrances";
            case FURNITURE: return "furniture";
            case GROCERIES: return "groceries";
        }
        return null;
    }

    public static Category forValue(String value) throws IOException {
        if (value.equals("beauty")) return BEAUTY;
        if (value.equals("fragrances")) return FRAGRANCES;
        if (value.equals("furniture")) return FURNITURE;
        if (value.equals("groceries")) return GROCERIES;
        throw new IOException("Categoría no reconocida por el sistema");
    }
}

/**
 * CLASE DE APOYO: Dimensions
 * Encapsula las medidas físicas del producto.
 */
@lombok.Data
class Dimensions {
    private double width;
    private double height;
    private double depth;
}

/**
 * CLASE DE APOYO: Meta
 * Almacena datos técnicos de identificación como códigos de barras o QR.
 */
@lombok.Data
class Meta {
    private String barcode;
    private String qrCode;
}

/**
 * ENUM: ReturnPolicy
 * Gestiona las diferentes políticas de devolución permitidas.
 */
enum ReturnPolicy {
    NO_RETURN_POLICY, THE_30_DAYS_RETURN_POLICY, THE_60_DAYS_RETURN_POLICY,
    THE_7_DAYS_RETURN_POLICY, THE_90_DAYS_RETURN_POLICY;

    public String toValue() {
        switch (this) {
            case NO_RETURN_POLICY: return "No return policy";
            case THE_30_DAYS_RETURN_POLICY: return "30 days return policy";
            case THE_60_DAYS_RETURN_POLICY: return "60 days return policy";
            case THE_7_DAYS_RETURN_POLICY: return "7 days return policy";
            case THE_90_DAYS_RETURN_POLICY: return "90 days return policy";
        }
        return null;
    }

    public static ReturnPolicy forValue(String value) throws IOException {
        if (value.equals("No return policy")) return NO_RETURN_POLICY;
        if (value.equals("30 days return policy")) return THE_30_DAYS_RETURN_POLICY;
        if (value.equals("60 days return policy")) return THE_60_DAYS_RETURN_POLICY;
        if (value.equals("7 days return policy")) return THE_7_DAYS_RETURN_POLICY;
        if (value.equals("90 days return policy")) return THE_90_DAYS_RETURN_POLICY;
        throw new IOException("Política de devolución no válida");
    }
}

/**
 * CLASE DE APOYO: Review
 * Representa el comentario y la calificación que un cliente deja sobre el producto.
 */
@lombok.Data
class Review {
    private long rating;
    private String comment;
    private String reviewerName;
    private String reviewerEmail;
}

/*Puntos clave de esta estructura:
    - Mapeo de APIs:    -> Los nombres de las variables (como discountPercentage) deben coincidir exactamente con
    las claves que devuelve la API (DummyJSON en este caso) para que librerías como GSON funcionen correctamente.
    - Modularidad:  -> Al separar Dimensions, Meta y Review en sus propias clases, el código es más fácil de mantener.
Si el formato de las reseñas cambia en el futuro, solo tocas la clase Review.
    - Seguridad con Enums:  -> Al usar ReturnPolicy o Category, impides que el programa acepte valores extraños que no
existan en la lógica de tu negocio. */