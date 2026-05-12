# fpro-Repaso_preguntas_examen

<br>

## 1. Concepto de Programación en Java e Instalaciones

<br>

- **JDK (Java Development Kit)**: Es el kit completo para desarrolladores. **Incluye el JRE, el compilador y otras herramientas indispensables** para crear programas.
- **JRE (Java Runtime Environment)**: Es el entorno de ejecución **que incluye la JVM y las bibliotecas estándar** necesarias para que los programas en Java funcionen en un ordenador.
- **JVM (Java Virtual Machine)**: Es la **máquina virtual** encargada de ejecutar el código compilado de Java (conocido como _bytecode_). **Es la clave que permite que Java sea multiplataforma.**
- **Compilador**: En Java (comando **javac**), es la herramienta que traduce el código fuente (el texto que tú escribes) a _bytecode_ para que la JVM pueda entenderlo.
- **IDE (Integrated Development Environment)**: Es el entorno de desarrollo integrado (como IntelliJ IDEA, Eclipse o NetBeans). **Proporciona un editor de texto, depurador y herramientas de construcción** en una sola interfaz para facilitar la programación.  
  <br>

## 2. Estructura de Programa: Modelo-Vista-Controlador (MVC)

<br>

- **Model (model):** Clases POJO que representan los datos puros.
- **View (view / Main):** Representa la interfaz gráfica o menús de consola.
- **Controller (controller):** Gestiona la lógica principal de la aplicación.
- **DAO:** aísla por completo las ejecuciones CRUD sobre la base de datos.
- **Otros paquetes habituales:** Se suelen añadir paquetes como **exceptions** (para errores personalizados), **utils** (herramientas misceláneas), **database** (conexiones y DAO) y **environments** (variables de entorno).  
  <br>

## 3. definir, declarar, instanciar e inicializar

<br>

- **Declarar**: **presentarle al compilador la existencia de algo** (una variable, un método o una clase) indicando su tipo y su nombre.
- **Inicializar**: es **asignar el primer valor** a una variable que ya ha sido declarada.
- **Instanciar** significa **crear un objeto real a partir de una clase** (que es el molde o la plantilla).
- **Definir:** describir **"lo que hace o lo que contiene"**. En el caso de las variables primitivas en Java, la declaración y la definición ocurren al mismo tiempo porque se define un espacio en memoria. Sin embargo, el término se usa muchísimo más al hablar de **métodos** o **clases**.  
  <br>

## 4. Variables y Tipos de Datos

Una variable es un espacio reservado en la memoria que tiene un nombre y almacena un valor específico que puede cambiar durante la ejecución. (  
<br>

**Tipos de datos**: Java tiene un tipado estático y divide los datos en dos grandes grupos:

- **_Primitivos_**: Almacenan valores simples y directos (ej. int para números enteros, double para decimales, boolean para verdadero/falso, char para caracteres).
- **Complejos** (El concepto general): cualquier dato que no sea primitivo, se le llama complejo porque no guarda un solo valor simple, sino que es un Objeto (que puede estar compuesto por múltiples datos internos (atributos) y puede realizar acciones (métodos)).
- **De Referencia**: Este término no define _qué_ es el dato, sino cómo lo maneja la computadora por debajo. Al definir una variable de tipo completo, este puede ser tan grande que no cabe directamente en la variable. Lo que hace el sistema es guardar el objeto en un gran espacio de memoria (el Heap) y una referencia en variable.

En la práctica: Todos los datos complejos en Java son datos de referencia. Por eso a veces la gente usa ambos términos indistintamente.

- **Wrapper** o Clase Envoltorio: convierte un dato primitivo en un dato complejo/referencia.  
  <br>

## 5. Estructuras de Control y Datos que admiten

<br>

- **Estructuras Condicionales (Toma de decisiones)**
  - **if / else if / else**
    - **Qué hace:** Evalúa una condición y ejecuta un bloque de código si es verdadera.
    - **Datos que admite:** Exclusivamente **valores o expresiones booleanas (boolean)**.
    - _Nota de examen:_ En lenguajes como C, C++ o JavaScript, puedes poner un número como if (1) y el lenguaje asume que es verdadero. **En Java esto da un error de compilación**. Java es de tipado estricto: solo admite true o false.

  - **switch**
    - **Qué hace:** Evalúa el valor de una variable y lo compara con múltiples casos posibles (case).
    - **Datos que admite:** Esta es la parte más importante para tu examen. A lo largo de la historia de Java, el switch ha ido admitiendo más tipos, pero **sigue teniendo restricciones muy concretas**. Solo admite:
      - Tipos primitivos enteros pequeños: byte, short, char e int.
      - Las clases envolventes de los anteriores (_wrappers_): Byte, Short, Character e Integer.
      - Cadenas de texto: String (soportado a partir de Java 7).
      - Clases enumeradas: enum.  
        <br>

- **2. Estructuras Repetitivas (Bucles)**
  - **while y do-while**
    - **Qué hacen:** Repiten un bloque de código mientras una condición siga siendo verdadera. (El do-while garantiza que el código se ejecute al menos una vez antes de comprobar la condición).
    - **Datos que admiten:** expresión booleana.

  - **for (Tradicional)**
    - **Qué hace:** Un bucle diseñado para ejecutarse un número específico de veces mediante un contador (la variable que se usa en inicio, condición y actualización).
    - **Datos que admite en su estructura:** El tradicional se divide en tres partes for(inicialización; condición; actualización).
    - **_Inicialización:_** Generalmente se declaran variables numéricas enteras (casi siempre int).
    - **_Condición:_** Debe ser estrictamente una **expresión booleana (boolean)** que decide cuándo debe detenerse el bucle.
    - **_Actualización:_** Admite operaciones numéricas (como i++ o i = i + 2).

  - **for-each (Bucle for mejorado)**
    - **Qué hace:** Sirve para iterar (recorrer) colecciones de datos elemento por elemento, de principio a fin, sin necesidad de gestionar un contador numérico.
    - **Datos que admite en su estructura:** Se escribe como for (Tipo variable : conjuntoDeDatos).
    - **A la derecha de los dos puntos (:):** Admite **Arrays** (arreglos de cualquier tipo) y cualquier estructura de datos que implemente la interfaz **Iterable** (como por ejemplo tu ArrayList). _Nota: Un HashMap no es directamente iterable, hay que extraer sus claves o valores primero._
    - **A la izquierda de los dos puntos:** La variable declarada debe ser exactamente del **mismo tipo de dato** (o una clase padre) de los elementos que contiene el array o la colección de la derecha.  
      <br>

_Casi todo en Java necesita un boolean para decidir el flujo de control, a excepción del switch, que busca coincidencias exactas y es muy quisquilloso con los 4 primitivos pequeños, sus wrappers, String y enum._  
<br>

## 6. Estructuras de Datos

<br>

- **Iterables** - **Array (Arreglo)**: Estructura básica, de tamaño fijo, una vez creado, no puede cambiar su longitud. Admite tanto tipos primitivos como objetos. - **ArrayList**: Implementación de una lista basada en un arreglo dinámico. Su tamaño se ajusta automáticamente al añadir o quitar elementos. Solo puede almacenar objetos (para primitivos se usan sus clases envolventes o _wrappers_ como Integer).  
  <br>

- **Clave-valor** - **HashMap**: Estructura de datos basada en diccionarios que almacena pares clave-valor. Permite búsquedas y accesos casi instantáneos utilizando la "clave" única para extraer su "valor" asociado.  
  <br>

## 7. Conceptos de Programación Orientada a Objetos (POO)

<br>

- **Encapsulación**: Es la práctica de ocultar el estado interno de los objetos (hacer atributos private) y obligar a que la interacción externa se haga a través de métodos públicos controlados (como _getters_ y _setters_).
- **Herencia**: Mecanismo que permite crear una clase nueva basada en una clase existente. Se heredan sus atributos y métodos (usando la palabra **extends**), promoviendo la reutilización de código.
  - **Qué se hereda**:
    - **Todos los métodos public:** Cualquier parte de tu aplicación podrá usarlos.
    - **Todos los métodos protected:** Podrán usarlos las clases hijas y las clases que estén en el mismo paquete.
    - **Todos los métodos _package-private_ (sin modificador):** Solo si la clase hija está en la misma carpeta/paquete que el padre.
    - **Los atributos (a excepción de los private -**\> con getter / setter).

  - **Qué NO se hereda:**
    - Los métodos **private** (son exclusivos e invisibles fuera de la clase donde se crearon).
    - Los **Constructores** (cada clase debe definir cómo se construye a sí misma, aunque la hija puede llamar al constructor del padre usando super()).

- **Polimorfismo**: Es la capacidad de los objetos de adoptar diferentes formas. Permite que objetos de diferentes clases hijas respondan al mismo método de manera distinta, o que una variable de la clase padre pueda referenciar a cualquier objeto de sus clases hijas.

- **Abstracción:** Centrarse en _qué_ hace un objeto en lugar de _cómo_ lo hace, ocultando la complejidad interna. Consiste en **mostrar solo lo esencial de un objeto y ocultar toda la complejidad innecesaria** de cómo funciona por dentro.  
  <br>

## 8. Interfaces

Las interfaces permiten llevar al máximo la abstracción y polimorfismo.

Son el nivel más puro de abstracción que existe en Java. De hecho, ni siquiera se pide escribir la palabra abstract al definirlas. (Se definen como **public interface**)

Son un **contrato 100% estricto** que define _qué_ acciones debe poder hacer una clase, pero no _cómo_ debe hacerlas. No se pueden instanciar, se usan mediante **implements.**

**Contienen:**

- Métodos abstractos: Solo nombre y retorno PERO SIN CUERPO {}.
- Atributos constantes (public static final POR DEFECTO).
- Si una clase normal (no abstracta) usa **implements**, está **100% obligada** a sobreescribir el código de todos y cada uno de los métodos de la interfaz con @Override  
  <br>

## 9. Funciones Stream y BiFunction

- **Funciones Stream**: Permiten procesar secuencias de datos (como colecciones) de forma declarativa. Facilita operaciones como filtrar (filter), ordenar (sort) transformar (map) o reducir datos sin necesidad de usar bucles for tradicionales
- **BiFunction**: Es una interfaz funcional específica que recibe dos argumentos de entrada y devuelve un único resultado. Es muy útil cuando se necesita combinar dos elementos para crear uno nuevo dentro de un flujo de datos.  
  <br>

## 10. Excepciones

- **Qué son**: Las excepciones son eventos anómalos o errores que interrumpen el flujo normal de ejecución de un programa.
- **Bloque de gestión**: Se gestionan atrapándolas con la estructura try-catch-finally. El código que puede fallar se envuelve en el try, la respuesta al error va en el catch, y las tareas de limpieza obligatorias se colocan en el finally.
- **Cómo controlarlas**: Además de capturarlas, puedes declarar que un método las delega a quien lo llame usando la palabra reservada throws en la firma del método, o puedes generar las tuyas propias usando throw.  
  <br>

## 11. JSON y Extracción de Información

- **Qué es JSON**: _JavaScript Object Notation_ es un formato de texto ligero, fácil de leer y escribir tanto para humanos como para máquinas. Estructura los datos en pares de atributos-valores.
- **Para qué vale**: Se ha convertido en el estándar de oro para transmitir datos en la web (por ejemplo, comunicación entre un servidor y una aplicación Java).
- **Cómo se extrae información**: En Java, la extracción o "parseo" de información desde un archivo o respuesta JSON requiere leer los datos y transformarlos en objetos Java utilizables. Esto se logra comúnmente usando librerías de terceros (como Jackson o Gson) o usando clases para navegar por sus nodos.  
  <br>

## 12. Flujos I/O (Input / Output Streams)

- **Flujos I/O**: Un _Stream_ o flujo representa una conexión secuencial hacia un origen de datos (como un archivo o un teclado para _Input_) o un destino de datos (como una pantalla o un documento para _Output_). Se clasifican principalmente en flujos de bytes (archivos binarios, imágenes) y flujos de caracteres (archivos de texto).  
  <br>

## 13. Recursividad

- **Concepto**: Es el proceso mediante el cual un método o función se llama a sí mismo de manera repetida desde dentro de su propio bloque de código.
- **Para qué sirve**: Es muy útil para resolver problemas complejos dividiéndolos en subproblemas idénticos más pequeños (por ejemplo, recorrer la estructura de carpetas de tu disco duro, árboles de datos o calcular series matemáticas). Es indispensable que la función cuente con un "caso base" para que la repetición se detenga y no se genere un bucle infinito.
