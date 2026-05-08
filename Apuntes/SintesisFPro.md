**1\. Ingeniería de Software y Ciclo de Vida**

Antes de escribir una sola línea de código, hay un proceso metódico para resolver problemas mediante **Algoritmos** (pequeños pasos con un Input, un Proceso y un Output que solucionan el problema general). Programar es diseñar "n" algoritmos aplicando la filosofía de "divide y vencerás".

- **Fases de Desarrollo:** Todo proyecto profesional sigue un ciclo:
  - 1\. Planificar (pensar la solución).
  - 2\. Diseño (UML, Wireframes, diagramas de bases de datos).
  - 3\. Codificación.
  - 4\. Pruebas (Beta).
  - 5\. Lanzamiento (al servidor o generando instalables).
  - 6\. Mantenimiento.
- **Optimización:** Programar no es solo hacer que funcione. Un buen código usa menos líneas (menos ciclos de CPU), reduce los accesos al disco y minimiza el uso de memoria RAM.
- **Buenas Prácticas:** Para mantener el código limpio, debes separar funcionalidades en distintos métodos, minimizar el uso de variables static, evitar anidar más de dos estructuras de repetición (bucles) y ser cuidadoso con el uso de return y break en iteraciones poco profundas.  
  <br>

**2\. Arquitectura del Proyecto (MVC y Paquetes)**

Para que un proyecto sea escalable, se divide en paquetes que gestionan la visibilidad (si usas protected, solo las clases del mismo paquete acceden a esa información).

- **Patrón MVC (Model-View-Controller):** \*
  - **Model (model):** Clases POJO que representan los datos puros.
  - **View (view / Main):** Representa la interfaz gráfica o menús de consola.
  - **Controller (controller):** Gestiona la lógica principal de la aplicación.
  - **DAO:** aísla por completo las ejecuciones CRUD sobre la base de datos.
  - **Otros paquetes habituales:** Se suelen añadir paquetes como exceptions (para errores personalizados), utils (herramientas misceláneas), database (conexiones y DAO) y environments (variables de entorno).
- **Maven vs Local:** En vez de descargar librerías e inyectarlas manualmente en IntelliJ (Local), Maven centraliza estas descargas bajo demanda en un servidor mediante un archivo llamado pom.xml.  
  <br>

**3\. Recursividad**

La recursividad consiste en que un método se llame a sí mismo para resolver un problema dividiéndolo en partes más pequeñas.

- **Ventajas:** Ofrece un código muy limpio para funciones complejas, como la lectura de directorios y subdirectorios anidados.
- **Peligros y Reglas:** Nunca debe usarse para tareas simples (como leer líneas de un archivo con while), ya que consume mucha memoria. Es estrictamente obligatorio programar uno o varios "Casos Base" para detener las llamadas y evitar bucles infinitos.  
  <br>

**4\. Programación Funcional y Lambdas**

Para hacer el código más declarativo y usar _callbacks_ (funciones que se ejecutan después de otras), Java utiliza la programación funcional.

- **Expresiones Lambda:** Siguen la sintaxis parametro -> cuerpo. Si la lambda tiene una sola línea, el return es implícito; si abres llaves {}, debes escribir return explícitamente. Se usan masivamente en flujos de datos (stream().map()).
- **Interfaces Funcionales (Bi):**
  - BiFunction&lt;G1, G2, G3&gt;: Admite tres parámetros (dos de entrada y el tercero define el tipo de retorno) y se usa para ejecutar _callbacks_ complejos mediante el método .apply().
  - BiPredicate y BiConsumer: Variantes que admiten dos parámetros y se usan habitualmente en filtros o acciones terminales.
- **Referencias de Métodos:** Es una sintaxis de acceso directo (Clase::metodo) que sustituye a las lambdas cuando no es necesario declarar parámetros explícitos, ya que el objeto llama al método de forma implícita.  
  <br>

**5\. Gestión de Excepciones**

**Excepciones:** Son fallos producidos en el código que deben tratarse para asegurar la disponibilidad del programa.

- **Tipos:**
  - **Excepciones en tiempo de ejecución (Unchecked o RunTime)**, como NullPointerException o ArithmeticException no son de obligada captura.
  - **Excepciones chequeadas (**Checked), como IOException, dependen de elementos externos y deben capturarse obligatoriamente.
- **Captura:** El bloque try-catch-finally intenta ejecutar el código, captura el error en el momento y siempre ejecuta la porción finally al terminar. La palabra throws en la firma de un método delega la resolución del error a quien llame a dicho método.  
  <br>

**6\. Lombok**

Es una librería que genera código de manera automática durante el tiempo de compilación.

- **@Getter y @Setter:** Son anotaciones de Lombok que generan automáticamente los métodos de lectura y escritura para los atributos privados, respetando así el principio de encapsulación.
- **@AllArgsConstructor:** Instruye a Lombok para crear un constructor que incluya todos los atributos de la clase.
- **@NoArgsConstructor:** Genera un constructor completamente vacío. Esto es estrictamente necesario.
- **Sobrescritura de toString():** Al sobrescribir este método (a menudo usando String.format), se personaliza qué texto se muestra por consola al imprimir directamente la instancia del objeto.
- **Sobrescritura de EqualsAndHashCode** **():** métodos que causan problemas con los ORM.
