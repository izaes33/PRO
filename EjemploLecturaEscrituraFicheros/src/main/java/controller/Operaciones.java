package controller; // La clase pertenece al paquete controller

import java.io.*; // Importaciones necesarias para trabajar con ficheros
import java.util.Scanner; // Para leer datos desde teclado


public class Operaciones { // Declaración de la clase


    /* mostrarFicheros:
     Recorre una carpeta y muestra todos los archivos.
     Usa recursividad para entrar en subcarpetas. */

    public void mostrarFicheros(String path) {

        File file = new File(path);// Se crea un objeto File que representa la ruta indicada
        System.out.println(file.getName());// Muestra el nombre del archivo o carpeta

        if (file.isDirectory()) { // Si el objeto File representa una carpeta
            for (File item : file.listFiles()) { // listFiles() devuelve todos los elementos de la carpeta
                leerFichero(item.getAbsolutePath()); // Se llama al mismo método para recorrer subcarpetas
            }
        }
    }
    /* Recursividad = un método que se llama a sí mismo.
 Ejemplo:

 leerFichero(carpeta)
     si es carpeta
         recorrer contenido
             llamar otra vez a leerFichero()

(Esto permite recorrer todo el árbol de directorios). */




    /* leerContenidoFichero:
    Lee el contenido de un fichero carácter por carácter. (Utiliza FileReader). */

    public void leerContenidoFichero(String path) {  //El método recibe la ruta
        File file = new File(path); // Representa el fichero creando un objeto de tipo File
        FileReader fileReader = null; /* Se declara el flujo de lectura de caracteres
        fuera del try para que sea accesible desde finally */

        try {
            fileReader = new FileReader(file); /* Se crea un FileReader que abre el archivo
            y convierte bytes a caracteres */

            int codigo;
            while ((codigo = fileReader.read()) != -1) { // -1 significa fin del fichero.
                // read() devuelve el código ASCII del carácter
                System.out.print((char) codigo); // Convertimos el código ASCII a carácter
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero que intentas leer no existe");

        } catch (IOException e) {
            System.out.println("No cuentas con los permisos suficientes");

        } finally {
            try {
                fileReader.close(); // Cerramos el flujo para liberar recursos y GUARDAR CAMBIOS
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }




    /* leerContenidoFicheroLineas:
    Lee un fichero línea por línea.
    Usa BufferedReader, que es más eficiente
    que leer carácter por carácter. */

    public void leerContenidoFicheroLineas(String path) {
        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file)); /* BufferedReader envuelve a FileReader
            mejorando el rendimiento y permitiendo readLine() */

            String linea; //Almacenará cada línea leída.
            while ((linea = bufferedReader.readLine()) != null) { /* readLine() devuelve una línea completa
            en cada iteración del while; readLine devuelve null cuando llega al final del archivo) */
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("La ruta es incorrecta");

        } catch (IOException e) {
            System.out.println("No cuentas con los permisos suficientes");

        } finally {
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado del fichero");
            }
        }
    }




    /* escrituraLineas:
    Escribe varias líneas dentro de un fichero.
    Usa PrintWriter para facilitar la escritura de texto
    con saltos de línea automáticos. */

    public void escrituraLineas(String path) {
        File file = new File(path);
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file));
            printWriter.println("1Me imprime la linea dentro del fichero y luego salto de linea");
            printWriter.println("2Me imprime la linea dentro del fichero y luego salto de linea");
            printWriter.println("3Me imprime la linea dentro del fichero y luego salto de linea");
            printWriter.println("4Me imprime la linea dentro del fichero y luego salto de linea");
        } catch (IOException e) {
            System.out.println("Fallo en el proceso de escritura");

        } finally {
            try {
                printWriter.close();
            } catch (Exception e) {
                System.out.printf("Fallo en el proceso de cerrado con error %s", e.getMessage());
            }
        }
    }
/* En vez de usar printWritter se puede utilizar bufferedWritter.write, con la diferencia de que tras cada línea
* habría que ejecutar bufferedWritter.newLine() para indicar los saltos de línea
* En la escritura NO es posible que aparezca un FileNotFound, y por siguiente, tampoco puede aparecer
* NullPointer en el cierre, y por eso no es necesario ni adecuado tratar ninguna de ellas. */



    /* escrituraCifrada: escribe un mensaje cifrado dentro de un fichero
    mediante un cifrado  muy simple que se basa en los códigos ASCII
    de los caracteres.

PROCESO DE CIFRADO:
1. El usuario introduce una clave de cifrado.
2. El usuario introduce un mensaje de texto.
3. Cada carácter del mensaje se convierte a su código ASCII.
4. Ese código ASCII se multiplica por la clave.
5. El número resultante se guarda en el fichero.

Ejemplo:
Mensaje original: Hola
Códigos ASCII: H = 72; o = 111 ; l = 108 ; a = 97
Si la clave es 10: 72 * 10 = 720; 111 * 10 = 1110 ; 108 * 10 = 1080 ; 97 * 10 = 970
(Cada número se separa con un espacio para poder reconstruir el mensaje posteriormente).
En el fichero se guardará: 720 1110 1080 970

Luego el método descifrarContenido hará el proceso inverso:
codigoASCII = numeroGuardado / clave
*/

    public void escrituraFichero(String path) {

        File file = new File(path); /*Se crea un objeto File que representa el fichero
        donde se guardará el mensaje cifrado */

        FileWriter fileWriter = null; // FileWriter permite escribir caracteres dentro de un fichero

        Scanner scanner = new Scanner(System.in);

        try {
            fileWriter = new FileWriter(file, true);/* El parámetro "true" significa modo APPEND.
        Esto quiere decir:
        - NO se borra el contenido anterior del fichero
        - el nuevo contenido se añade al final */

            System.out.println("Dime como quieres cifrar el mensaje");
            int clave = scanner.nextInt();

            scanner = new Scanner(System.in); /* Se vuelve a crear el Scanner para poder leer una línea
        completa de texto después de haber usado nextInt(). */
            System.out.println("Dime que quieres guardar en el fichero");
            String mensaje = scanner.nextLine(); // Se lee el mensaje completo

            for (int i = 0; i < mensaje.length(); i++) { /* Se recorre el mensaje carácter por carácter
        usando un bucle for. */
                char letra = mensaje.charAt(i); // charAt(i) obtiene el carácter en la posición i

                int codigoAscii = (int) letra; /* Convertir el carácter a su código ASCII en Java esto se puede hacer
            haciendo un casting a int. */

                int codigoCifrado = codigoAscii * clave; /* Aplicamos el cifrado multiplicando por la clave
            introducida por el usuario. */

                fileWriter.write(String.valueOf(codigoCifrado)); /* write() escribe texto en el fichero.
            Como write() trabaja con texto, convertimos el número a String. */

                fileWriter.write(" "); /* Se añade un espacio después de cada número
            para poder separar los valores en el futuro cuando se descifre el mensaje. */
            }

        } catch (IOException e) { // Error general de escritura (permisos, disco, etc.)
            System.out.println("error en la escritura del fichero");

        } finally {
        /* Aquí se cierra el flujo de escritura para liberar recursos
        y asegurar que los datos se guardan correctamente */
            try {
                fileWriter.close();
// Puede fallar si el flujo nunca llegó a abrirse
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }




    /* descifrarContenido:
    Este método se encarga de leer un fichero que contiene
    números cifrados y convertirlos de nuevo en texto legible.

    El fichero contiene números separados por espacios.
    Ejemplo: 720 690 760 760 790
    (Estos números se generaron previamente con el método
    de cifrado -> codigoCifrado = codigoASCII * clave)

    Por tanto, para descifrar debemos hacer: codigoASCII = codigoCifrado / clave

    Una vez obtenido el código ASCII, se convierte de nuevo
    a carácter (char) para recuperar el texto original.

    PASOS DEL MÉTODO:
    1. Abrir el fichero
    2. Pedir al usuario la clave de cifrado
    3. Leer la línea del fichero
    4. Separar los números usando el espacio como delimitador
    5. Convertir cada número a entero
    6. Dividir entre la clave
    7. Convertir el resultado a carácter
    8. Mostrar el carácter */

    public void descifrarContenido(String path) {

        File file = new File(path);         // Se crea un objeto File que representa el fichero

        BufferedReader reader = null; /* BufferedReader permitirá leer el contenido del fichero
        de forma eficiente (línea por línea) */

        Scanner scanner = new Scanner(System.in);

        try {
            reader = new BufferedReader(new FileReader(file)); /* Se crea el flujo de lectura:
            FileReader lee caracteres del fichero
            BufferedReader mejora la eficiencia de lectura */

            System.out.println("Dime cual es la clave de cifrado");
            int clave = scanner.nextInt();

            String linea = reader.readLine(); /* Se lee la primera línea del fichero
            (readLine() devuelve un String con toda la línea). */

            String[] numeros = linea.split(" ");
            /* La línea contiene números separados por espacios. Ejemplo: "720 690 760"
            split(" ") divide el texto usando el espacio como separador */

            for (String item : numeros) { // Se recorren todos los números obtenidos
                int codigoCifrado = Integer.parseInt(item); // Se convierte cada número (String) a entero
                int codigoAscii = codigoCifrado / clave; // Se descifra dividiendo entre la clave
                char letra = (char) codigoAscii; // Se convierte el código ASCII a carácter
                System.out.print(letra); // Se imprime el carácter recuperado
            }

        } catch (FileNotFoundException e) { // Se ejecuta si el fichero no existe o la ruta es incorrecta
            System.out.println("El fichero no es valido");

        } catch (IOException e) { // Error general de entrada/salida (permisos, lectura, etc.)
            System.out.println("Error en la lectura del fichero, sin permisos");

        } finally { // El bloque finally se utiliza para cerrar el flujo de lectura
            try {
                reader.close();

            } catch (IOException | NullPointerException e) { // Puede fallar si el flujo no se llegó a abrir
                System.out.println("Error en el cerrado");
            }
        }
    }
    /* El código usa un cifrado simple basado en ASCII.
Proceso de cifrado:
 1. Convertir cada carácter a su código ASCII
 2. Multiplicarlo por una clave (codigo = letra * clave)
 3. Guardar el número
Proceso de descifrado:
 1. Leer el número
 2. Dividir entre la clave (letra = codigo / clave)
 3. Después se convierte de nuevo a carácter. */
}