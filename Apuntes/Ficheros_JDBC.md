**1. Persistencia de Datos: Ficheros vs Bases de Datos**

Los datos en memoria RAM (variables) mueren al cerrar el programa. Necesitamos persistencia.

- **Ficheros (Serialización):** Guardar un objeto directamente en un archivo (.dat) requiere desarmarlo en bytes. Esto es la serialización (ObjectOutputStream). Es muy útil para partidas guardadas de juegos o configuraciones de usuario. Sin embargo, no sirve si múltiples usuarios quieren acceder o modificar los datos al mismo tiempo.
- **Bases de Datos relacionales (JDBC):** Aquí entra SQL. El gran peligro al conectar Java con SQL es la "Inyección SQL". Si usas un Statement genérico, Java concatena ese texto directo a la base de datos y le da acceso al hacker. Por eso es obligatorio usar PreparedStatement: Java pre-compila la consulta y trata todo lo introducido por el usuario como simple texto inofensivo, neutralizando el ataque.
- **El Patrón DAO (Data Access Object):** Centraliza todas las consultas SQL (INSERT, SELECT) en una sola clase (ej. UsuarioDAO). Si el día de mañana se decide cambiar de MySQL a Oracle o a una base de datos NoSQL como MongoDB, solo se tendrá que reescribir la clase DAO. El resto del sistema ni se inmutará.  
  <br>

**2\. Procesamiento Funcional (Java Streams)**

La API de Streams (disponible desde Java 8) permite procesar colecciones de datos creando "tuberías" de forma rápida y legible, reemplazando bucles for complejos.

**Operaciones clave en la tubería:**

- **stream():** Abre la tubería para que los datos comiencen a fluir.
- **filter():** Filtra los elementos según una condición, quedándose solo con los que la cumplen. Esta condición se define mediante Expresiones Lambda (usando ->, que significa "dado este elemento, comprueba esto").
- **mapToDouble():** Extrae un dato numérico específico de cada objeto para realizar cálculos.
- **anyMatch():** Verifica si al menos un elemento de la tubería cumple una condición, devolviendo un booleano.
- **forEach():** Realiza una acción final por cada elemento que sobrevive hasta el final de la tubería.  
  <br>

**3\. Ficheros y Flujos (I/O Streams)**

Los ficheros permiten almacenar datos permanentemente.

**La clase File:** Representa una ruta en el sistema operativo pero NO lee ni escribe datos por sí misma. Ofrece métodos informativos como exists(), isFile(), isDirectory(), length(), getName(), getAbsolutePath(), y de creación como createNewFile().

**Flujos (Streams) de Lectura y Escritura:** Un flujo es el canal que transporta los datos entre el programa y el archivo.

- **Lectura (Input/Reader):** FileReader lee carácter a carácter (usando read(), que devuelve el código ASCII o -1 al finalizar). Para mejor rendimiento y para poder leer líneas completas mediante readLine(), se envuelve en un BufferedReader.
- **Escritura (Output/Writer):** FileWriter escribe caracteres y permite el modo de "añadir contenido sin borrar" usando el parámetro true. Para facilitar la escritura de texto, se usa PrintWriter con sus métodos print() y println().

Si los flujos son bit a bit se usan FileReader o FileWriter. Si queremos hacerlo línea a línea se utilizan clases con buffer intermedio como BufferedReader o PrintWriter. Para guardar objetos complejos como información binaria, el objeto debe implementar Serializable.

**Reglas de seguridad en ficheros:**

- Siempre debes cerrar el flujo con close() dentro de un bloque finally para evitar archivos bloqueados o fugas de memoria.
- Las operaciones lanzan excepciones como FileNotFoundException (ruta incorrecta) o IOException (error de permisos o lectura).  
  <br>

**4\. Arquitectura y Bases de Datos (JDBC)**

Para la conexión nativa de Java a bases de datos relacionales como MySQL se utiliza la API JDBC. Se utiliza la interfaz Connection con su URL correspondiente, y es muy recomendable aplicarle el patrón _Singleton_ (variable estática única) para no saturar los recursos del sistema.

**Patrones de diseño fundamentales:**

- **Arquitectura MVC:** Divide la aplicación en capas: Modelo (datos puros), Controlador (lógica de negocio) y Acceso a Datos (consultas a base de datos).
- **Patrón DAO (Data Access Object):** Separa la lógica de acceso a la base de datos de la lógica de la aplicación, permitiendo cambiar el motor de base de datos sin afectar al resto del programa.
- **Patrón Singleton:** Garantiza que se instancie una única conexión a la base de datos, ahorrando recursos valiosos y evitando el "coste" de abrir y cerrar conexiones continuamente.

**Seguridad y Código Limpio:**

- **Inyección SQL:** Jamás se debe utilizar Statement genérico. En su lugar, usa PreparedStatement, que pre-compila el SQL y usa parámetros seguros (?) para evitar inyecciones de código malicioso.
