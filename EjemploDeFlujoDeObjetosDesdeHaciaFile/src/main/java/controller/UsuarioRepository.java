package controller;

import model.Usuario;
import java.io.*;
import java.util.List;

public class UsuarioRepository {

    public void guardarUsuarios(String path, List<Usuario> usuarios) {
        /* El try-with-resources asegura que el ObjectOutputStream se cierre solo al terminar.
        Es una estructura de control introducida en Java 7 que garantiza que los recursos (como archivos,
        conexiones a bases de datos o flujos de red) se cierren automáticamente al finalizar el bloque
        de código.
        Con try-with-resources, el recurso se declara e inicializa entre paréntesis justo después de
        la palabra try */
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            // Se escribe el objeto lista completo. Al ser List y Usuario serializables, funciona
            oos.writeObject(usuarios);
            System.out.println("Usuarios guardados correctamente en: " + path);
        } catch (IOException e) {
            System.out.println("Error al guardar los usuarios: " + e.getMessage());
        }
    }

    public List<Usuario> lecturaObjeto(String path) {
        File file = new File(path);
        // Validación preventiva: si el archivo no existe, no intentamos abrir el stream
        if (!file.exists()) {
            throw new RuntimeException("El fichero no existe en la ruta: " + path);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            // Leemos el objeto genérico del archivo
            Object objetoLeido = ois.readObject();

            // Verificamos el tipo para evitar errores de ClassCastException
            if (objetoLeido instanceof List<?>) {
                // Casting a la lista de usuarios. El @SuppressWarnings oculta el aviso de tipo no comprobado
                @SuppressWarnings("unchecked")
                List<Usuario> lista = (List<Usuario>) objetoLeido;
                return lista;
            } else {
                throw new RuntimeException("El contenido del archivo no es una lista válida.");
            }
        } catch (IOException | ClassNotFoundException e) {
            // Capturamos tanto errores de lectura como el caso en que la clase Usuario no exista
            throw new RuntimeException("Error durante la lectura del objeto", e);
        }
        /* Para ser técnicamente precisos, @SuppressWarnings no es un método ni pertenece a una clase convencional;
        es una Anotación (un tipo especial de interfaz) definida en el núcleo del lenguaje Java.
        Esta anotación le dice al compilador: "Sé lo que estoy haciendo, por favor, no me muestres
        una advertencia (warning) sobre este pedazo de código".
        El parámetro "unchecked" se refiere específicamente a operaciones de conversión de tipo (casting) que
        el compilador no puede verificar como seguras al 100% en tiempo de compilación.
        (Cuando se usa ObjectInputStream.readObject(), el método devuelve un objeto de tipo genérico Object.
        Java sabe que ha leído "algo" del archivo, pero no tiene forma de saber si ese "algo" es una String,
        un Integer o tu List<Usuario> hasta que el programa se está ejecutando.
        Cuando le escribes (List<Usuario>) objetoLeido, se fuerza la conversión y el compilador  lanza
        un aviso (amarillo) diciendo: "Oye, voy a intentar convertir esto, pero no te garantizo que dentro de
        esa lista haya realmente objetos de tipo Usuario").
        Lo que hace exactamente es:
        - Silenciar el aviso de "Type safety: Unchecked cast".
        - No elimina el riesgo.
        - Documenta intención: Le indica a otros programadores que tú, como autor, eres consciente de que
        ahí hay una conversión de riesgo y que has validado previamente el objeto */
    }
}