/* Crea un programa con un array de 10 palabras (pueden repetirse).
Pide al usuario una palabra y usa un bucle for para contar cuántas veces
aparece esa palabra en el array.

Ejemplo de salida por consola:
Array: ["gato", "perro", "gato", "pájaro", "gato", "pez", "perro", "gato", "conejo", "perro"]
Introduce la palabra a buscar: gato
La palabra "gato" aparece 4 veces en el array */

package ContarElemento;
import java.util.Scanner;
import java.text.Normalizer;

public class ContarElemento {

    public void contar() {

        Scanner teclado = new Scanner(System.in);

        String elementos[] = {
                "moto", "coche", "bici", "autobus", "camion",
                "tren", "barco", "moto", "barco", "avion"
        };

        System.out.print("Introduce la palabra a buscar: ");
        String palabraUsuario = quitarTildes(teclado.next());

        int contador = 0;

        // Versión con for-each
        for (String elemento : elementos) {
            if (quitarTildes(elemento).equalsIgnoreCase(palabraUsuario)) {
                contador++;
            }
        }

        System.out.println("La palabra \"" + palabraUsuario + "\" aparece " + contador + " veces en el array");

        teclado.close();
    }

    public static String quitarTildes(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD) //Esta línea convierte la cadena texto a la forma de normalización Unicode NFD, que significa Forma de Descomposición Canónica (Normalization Form Decomposed).
                .replaceAll("\\p{M}", ""); //Elimina todas las marcas diacríticas que quedaron después de la descomposición NFD. p{M} es una clase Unicode que coincide con:
        //acentos, tildes, diéresis, virgulillas, cedillas, cualquier marca combinante. (Como se reemplazan por "", se borran).
        /* (Una clase Unicode (o propiedad Unicode) es una categoría que agrupa caracteres según su función dentro del estándar Unicode.
        Sirve para identificar tipos de caracteres como letras, números, signos, espacios, marcas diacríticas, etc.
        Ejemplos de clases Unicode importantes:
        \p{L} Todos los caracteres que son letras
        \p{N} Todos los números
        \p{M} Todas las marcas combinantes (tildes, diéresis, etc.).
        Una clase Unicode sirve para decirle a tu expresión regular qué tipo de caracteres quieres seleccionar, independientemente del idioma o del alfabeto)).*/
/* El método convierte una cadena Unicode a su forma decompuesta (NFD), donde las letras
con acento se separan en letra base + marca combinante, y luego elimina todas las marcas
combinantes (\p{M}) —con lo que las tildes, diéresis, virgulillas, cedillas, etc. se quitan,
devolviendo la cadena "sin tildes". Esto también convierte ñ → n, ç → c, etc. */

/* El estándar Unicode es un sistema universal que define un número único para cada carácter que existe en cualquier idioma o escritura del mundo.
Es la base de cómo hoy se representan textos en ordenadores, móviles, webs, bases de datos, etc.
Antes de Unicode, cada sistema operativo, idioma o país usaba su propia “tabla de caracteres”. Eso causaba problemas como:
un mismo número representaba letras distintas según el idioma, archivos que se veían mal en otros equipos,
imposibilidad de mezclar idiomas (ej. español + ruso + japonés) en un mismo texto.
Unicode solucionó eso definiendo un código único para cada carácter
Ejemplos:
'A' → U+0041
'á' → U+00E1
'你' → U+4F60
'🙂' → U+1F642
Incluye prácticamente todos los sistemas de escritura del mundo, actuales y antiguos:
Latín (todas sus variantes con tildes)
Árabe
Chino/Japonés/Coreano
Cirílico
Griego
Emoji
Símbolos matemáticos, técnicos, musicales, etc.
✔ Puntos clave
Unicode es un mapa global de caracteres.
No es una codificación en sí; eso lo hacen sistemas como UTF-8, UTF-16, UTF-32, que implementan Unicode en bytes.
Permite que un archivo, texto o programa se vea igual en cualquier sitio.

Normalizer.normalize(texto, Normalizer.Form.NFD) usa reglas definidas por el estándar Unicode que dicen cómo descomponer caracteres en:
letra base - marcas diacríticas */
    }
}