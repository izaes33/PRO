package controller;
import model.Usuario;

import java.io.*;
import java.util.List;

public class UsuarioRepository {

    public void guardarUsuarios(String path, List<Usuario> usuarios) {

        // try-with-resources: el stream se cierra automáticamente
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(path))) {

            // Se escribe directamente la lista recibida como parámetro
            // writeObject convierte la lista en una secuencia de bytes OBJETO POR OBJETO
            oos.writeObject(usuarios);

            System.out.println("Usuarios guardados correctamente");

        } catch (IOException e) {
            System.out.println("Error al guardar los usuarios");
            e.printStackTrace();
        }
    }

    public List<Usuario> lecturaObjeto(String path) {

        // 1️⃣ Creamos el objeto File
        File file = new File(path);

        // 2️⃣ Validamos si el archivo existe antes de intentar leerlo
        if (!file.exists()) {
            throw new RuntimeException("El fichero no existe en la ruta indicada");
        }

        // 3️⃣ Usamos try-with-resources para cerrar automáticamente el stream
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            // 4️⃣ Leemos el objeto del archivo
            Object objetoLeido = ois.readObject();

            // 5️⃣ Verificamos que realmente sea una lista
            if (objetoLeido instanceof List<?>) {

                // 6️⃣ Hacemos el casting seguro
                @SuppressWarnings("unchecked")
                List<Usuario> lista = (List<Usuario>) objetoLeido;

                // 7️⃣ Devolvemos la lista al método que lo llamó
                return lista;
            } else {
                throw new RuntimeException("El objeto leído no es una lista de Usuario");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Archivo no encontrado", e);

        } catch (IOException e) {
            throw new RuntimeException("Error de entrada/salida al leer el archivo", e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encuentra la clase Usuario", e);
        }
    }
}
