**1\. Fundamentos de Programación y Estructuras de Control**

**El ecosistema (JDK, JRE, JVM):** Escribes código usando las herramientas del **JDK** (Java Development Kit). Ese código se compila a un lenguaje intermedio llamado _Bytecode_. Luego, el **JRE** (Java Runtime Environment) provee las librerías base, y la **JVM** (Java Virtual Machine) es la máquina virtual que finalmente lee ese Bytecode y le da instrucciones a tu sistema operativo. Por eso Java es multiplataforma: la JVM se adapta a Windows, Mac o Linux.

**Variables:** Son un espacio reservado para guardar datos reutilizables. Sus nombres deben ser representativos, escribirse en minúscula, ser únicos en su ámbito de vida (local o global) y no pueden contener palabras reservadas ni caracteres especiales. Las variables declaradas como constantes usan el modificador final, su valor no puede alterarse y su nombre va en MAYÚSCULAS.

**Tipos de Datos:**

**_Primitivos:_** _Solo almacenan el valor directamente en memoria. Incluyen enteros (byte, short, int, long), decimales (float, double), lógicos (boolean: true/false) y caracteres (char: carácter de 2 bytes para Unicode)._

**Complejos**: Por cada tipo primitivo (que no tiene funcionalidades), el lenguaje proporciona un "tipo complejo" equivalente, que es un objeto, tiene métodos y se guarda en la memoria de forma diferente. Se usan mucho porque ciertas estructuras (como las Listas o ArrayList) no aceptan tipos primitivos, solo objetos.

- _int ➔_ **_Integer_**
- _double ➔_ **_Double_**
- _boolean ➔_ **_Boolean_**
- _char ➔_ **_Character_**
- _float ➔_ **_Float_**
- _byte ➔_ **_Byte_**
- _short ➔_ **_Short_**
- _long ➔_ **_Long_**

**Conversiones:** El "Casting" ocurre cuando los tipos encajan de forma natural (ej. un int que pasa a double). El "Parsing" es necesario cuando el cambio no es natural (ej. texto a número usando Integer.parseInt()) y puede fallar.  
<br>

**2\. La Memoria: ¿Qué es el Stack y el Heap y cómo se accede?**

Cuando el programa se ejecuta, la memoria RAM asignada se divide principalmente en dos zonas de trabajo: **El Stack (Pila)** y **El Heap (Montón)**. Entender esto es vital para saber la diferencia real entre tipos primitivos y complejos.

**A. La Memoria Stack (Pila)**

Es una memoria de tamaño fijo, muy ordenada y extremadamente rápida. Funciona bajo el principio LIFO (Último en entrar, primero en salir), como una pila de platos. Se usa para la ejecución del programa y las variables locales.

- **¿Qué guarda?:**
  - Las llamadas a las funciones/métodos.
  - **Los valores de los Tipos Primitivos** (un int, un boolean).
  - **Las Referencias** (direcciones de memoria) de los tipos complejos.
  - **Estados de ejecución** de métodos. _"Cuando termines de ejecutar el método B, debes volver exactamente a esta línea de código del método A para continuar"_.
- **¿Cómo se accede?:** El acceso es **directo e inmediato**. El procesador sabe exactamente dónde está el dato en la pila. Cuando una función termina, sus variables en el Stack se borran automáticamente e instantáneamente.

**B. La Memoria Heap (Montón o Montículo)**

Es una gran "piscina" de memoria dinámica, mucho más grande pero algo más desorganizada y ligeramente más lenta que el Stack.

- **¿Qué guarda?:**
  - **Todos los Objetos (Tipos complejos / De referencia).** Cada vez que usas la palabra new, el sistema busca un hueco libre en el Heap, mete ahí el objeto (por ejemplo, un String, un Double o un Coche) y te devuelve la dirección de dónde lo ha puesto.
- **¿Cómo se accede?:** El acceso es **indirecto**. Tú no puedes ir directamente al Heap. El proceso es:
  - El programa va al **Stack** a leer tu variable.
  - Ahí encuentra una "dirección" (referencia).
  - Sigue esa dirección hasta el **Heap** para encontrar y manipular el objeto real.
- **¿Quién la limpia?:** Como es dinámica, no se limpia sola al acabar una función. De esto se encarga un programa interno llamado **Garbage Collector (Recolector de Basura)**, que va mirando el Heap buscando objetos que ya no tienen ninguna variable en el Stack apuntando hacia ellos, y los borra para liberar espacio.

**C. Metaspace o Segmento de Código**

Cuando se compila y ejecuta un programa en lenguajes como Java o C#, las instrucciones del código se cargan en una esta zona (El código fuente de los métodos (las instrucciones lógicas, los if, los bucles, etc.)). Esta zona es de **solo lectura**. El programa no puede modificar su propio código mientras se ejecuta, solo puede leer las instrucciones.

**La Memoria y la palabra static:** Cuando creas un objeto con new, Java le reserva un bloque de memoria (Heap). Sin embargo, cuando declaras una variable o método como static, este no va al Heap del objeto, sino a un espacio global de la clase. Por eso el patrón **Singleton** usa variables static para la conexión a la base de datos: garantiza que toda la aplicación comparta el mismo "cable" físico de memoria, ahorrando recursos masivos.  
<br>

**3\. Declaración-Instanciación-Inicialización**

**1\. Declaración (Crear la etiqueta)**

Le dice al programa que va a necesitar un espacio para guardar algo y se le da un nombre.

- **En memoria:** Se reserva un hueco en el _Stack_ con el nombre de la variable, pero su valor es nulo (null).

**2\. Instanciación (Crear la realidad)**

Es cuando se **crea el objeto físico** en la memoria utilizando la palabra new.

- **En memoria:** Se reserva espacio en el _Heap_ para construir el objeto con todas sus propiedades.

**3\. Inicialización (Conectar ambas cosas)**

Es el acto de **asignar el objeto que se ha instanciado a la variable que ha declarado**. Se hace con el signo igual (=).

- **En memoria:** El hueco en el _Stack_ guarda la dirección de memoria de donde está el objeto en el _Heap_.

**Resumen:**

- **Declarar:** _"Quiero una variable que se llame X."_
- **Instanciar:** _"Fabrica un objeto real en la memoria."_
- **Inicializar:** _"Guarda ese objeto dentro de mi variable X."_  
  <br>

**4\. Operadores:**

- **_Aritméticos_**_:_ Suma, resta, multiplicación, división y resto.
- **_Relacionales_**_:_ Comparan valores (>, <, ==, !=) y devuelven un booleano.
- **_Lógicos_**_:_ AND (&&) devuelve true solo si todas las condiciones lo son. OR (||) devuelve true si al menos una condición lo es.
  - **Operadores AND (&& y &):** El operador && trabaja a nivel booleano y da como resultado TRUE únicamente cuando _todas_ las condiciones son verdaderas. El operador & realiza la misma función lógica, pero también puede operar a nivel de bits comparando secuencias binarias.
  - **Operadores OR (|| y |):** Este operador da como resultado TRUE cuando _al menos una_ de las condiciones es verdadera, siendo falso solo si todas son falsas. El símbolo | hace lo propio a nivel de bits.  
    <br>

**5\. Control de Flujo:**

- **_Selección_**_:_ **if/else** evalúa una condición booleana, mientras que **switch** evalúa el valor exacto de una variable (char, int, string).
- **_Repetición_**_:_ **for** ejecuta un bloque un número predeterminado de veces basándose en un rango numérico. **while** evalúa la condición primero (de 0 a n ejecuciones), mientras que **do-while** ejecuta primero y evalúa después (garantizando de 1 a n ejecuciones).
- **Saltos de Flujo:** Dentro de los bucles (FOR, WHILE, DO WHILE) puedes usar **continue** para saltar la iteración actual, **break** para romper el bucle por completo, o **return** para abortar y salir del método  
  <br>

**6\. Estructuras de Datos**

- **Estáticas (Arrays):** Tienen un tamaño fijo (No se pueden agregar ni eliminar elementos una vez creados) y funcionan mediante índices o posiciones (desde 0 hasta length - 1). Pueden ser unidimensionales (como un "armario con huecos") o multidimensionales (matrices con filas y columnas). Se acceden llamando a su índice, empezando siempre desde 0.
- **Dinámicas:** Son aquellas capaces de alterar su tamaño en tiempo de ejecución. Si se basan en posiciones usamos colecciones como ArrayList, y si se basan en pares clave/valor usamos HashMap.
  - **ArrayList (Dinámica e Indexada):** Colección que altera su tamaño automáticamente. Permite agregar (add), obtener (get), eliminar (remove) y conocer su tamaño (size) iterando con for o foreach.
  - **HashMap (Dinámica por Clave-Valor):** No usa posiciones, sino que asocia un identificador único a un dato (ej. DNI -> Persona). Usamos put(K,V) para insertar, get(K) para extraer y remove(K) para borrar. Para recorrerlo, iteramos sobre sus claves (o directamente sobre sus valores.  
    <br>

**7\. Programación Orientada a Objetos (POO)**

La POO nos permite crear el "molde" o estructura de un tipo de dato que tendrá una realidad individual.

- **Clases y Objetos:** Una clase es la plantilla básica para instanciar (crear) objetos. El nombre de las clases debe escribirse en singular y la primera letra en mayúscula. La clase principal requiere un método main, que actúa como la puerta de entrada de ejecución del programa. Las variables static pertenecen a la clase y no requieren que se instancie un objeto para acceder a ellas.
- **Abstracción y Encapsulamiento:** Son pilares fundamentales. El encapsulamiento exige que los atributos (las propiedades que caracterizan al objeto) sean privados (private). Para acceder y modificar estos valores desde el exterior, es obligatorio implementar métodos públicos conocidos como getter y setter.
- **Constructores y Métodos:** Los constructores son métodos especiales con el mismo nombre de la clase que indican cómo se inicializa un objeto (pueden haber varios con firmas distintas). Los métodos son verbos que dotan de acciones o funcionalidades al objeto.
- **Herencia y Polimorfismo:** La herencia **(mediante la palabra extends)** permite a una clase hija obtener propiedades de una clase padre, aunque en Java solo se puede heredar de una clase simultáneamente. Los constructores y elementos privados no se heredan directamente (requieren usar super()). El polimorfismo es la capacidad de "vestir" de varias formas a un elemento, por ejemplo, sobrescribiendo el comportamiento de un método heredado (usando @Override. Además, una clase hija también puede tener variables propias y métodos propios).
- **Polimorfismo en profundidad:** No es solo "sobrescribir" métodos (@Override). Es la capacidad de que una variable de la clase Padre (ej. List) apunte a un objeto de la clase Hija (ej. ArrayList). Esto te permite crear código altamente flexible. Si mañana quieres cambiar tu lista a un LinkedList, no tienes que reescribir todo tu programa, porque el resto del código solo interactúa con la "fachada" genérica.
  - ResultSet: Objeto que recibe los resultados de una consulta SELECT. Para extraer la información obtenida se requiere utilizar rs.next() para avanzar el puntero fila a fila.
