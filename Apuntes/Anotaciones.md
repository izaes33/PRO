# Anotaciones

<br>

**JDK**: JRE + compilador + herramientas

**JRE**: JVM + bibliotecas

**JVM**: Máq. virt. q permite multiplataforma

**Compilador:** javac

**IDE**: Editor + depurador + herram  
<br>

---

**Model:** datos.

**View / Main:** interfaz + menús

**Controller:** lógica

**DAO:** aísla ejecuciones CRUD

**Otros paquetes habituales:** exceptions, utils, database, environments  
<br>

---

**Declarar**: crear sin valor

**Inicializar**: Asignar valor a variable

**Instanciar**: Crear objeto

**Definir**: lo q hace un método, contiene una clase, o el espacio de una variable  
<br>

---

**Variable**: espacio reservado en memoria con tipo + nombre q almacena valor

**Dato primitivo**: valor simple y directo

**Dato complejo**: objeto con atributos y métodos

**D. de referencia**: "coordenada de memoria en Heap" para acceder desde una referencia en la variable. (Todos los complejos son de referencia).

**Wrapper / Envoltorio**: convierte primitivo en complejo.

**Clase**: plantilla para crear objetos.

**Constructor**: mismo nombre que la clase, indica como se inicializa un objeto.  
<br>

---

**Casteo**: cuando los tipos encajan de forma natural. Tipos

- Implícito / automático -> cuando no hay pérdida de información.
- Explícito -> forzado mediante paréntesis

**Parseo**: conversión de String a número, fecha u objeto JSON.

**Autobox**: conversión automática de primitivo a wrapper.

**Unbox**: proceso inverso.  
<br>

---

**MEMORIA**

- **Stack (pila) ->** ordenada y rápida, LIFO, guarda: llamadas a métodos, valores primitivos, referencias a datos complejos y estados de ejec.

- **Heap (montón) ->** más grande, desorganizada y lenta. Guarda todos los datos complejos, se accede mediante las referencias del Stack. Garbage Collector.  
  <br>

- **Static**: guarda una variable en el espacio global de la clase, permitiendo que todo el programa pueda acceder directamente a ella, sin necesidad de instanciar la clase.  
  <br>

---

**OPERADORES**:

- **Aritméticos**: + - \* / %

- **Relacionales**: &lt; &gt; == != Comparan y devuelven true / false

- **Lógicos** & && | ||  
  <br>

---

**ESTRUCT DE CONTROL ->**  
<br>

- **CONDICIONALES - SELECCIÓN->**
  - **if / else if / else:** Evalúan condición booleana true-false
  - **switch:** Compara un valor con múltiples casos (admite primitivos enteros pequeños (byte, short, char e int) y sus envolventes, String y enum.  
    <br>

- **BUCLES - REPETICIÓN->**
  - **while / do-while:** Repiten un bloque mientras una condic. sea true (do garantiza al menos 1 ejecuc). Sólo admiten boolean.
  - **for:** Ejecuta un nº específico de repeticiones mediante un contador-variable que se usa en **(inicio; condic.; actualizac.),** se inicia con variab. numéricas, la condic. es una exp booleana mediante el número que se ha de igualar mediante la actualización de la variable inicial.
  - **foreach: itera colecciones - for(Tipo variable : conjuntoDeDatos) sin necesidad de contador numérico.** Admite estructuras de datos iterables a la derecha de los dos puntos, y a la izquierda exactamente el mismo tipo de dato o una clase padre de los elementos de la colección.  
    <br>

_Casi todo en Java necesita un boolean para decidir el flujo de control, a excepción del switch, que busca coincidencias exactas y es muy quisquilloso con los 4 primitivos pequeños, sus wrappers, String y enum._  
<br>

---

**SALTOS DE FLUJO**

- **break** -> rompe la ejecución de la estructura de control

- **return** -> termina la ejecución del método

- **continue** -> salta una repetición en un bucle

(En un método con tipo de retorno se ha de usar return OBLIGATORIAMENTE AL FINAL DEL MÉTODO).  
<br>

---

**ESTRUCT DE DATOS**

- **ITERABLES**
  - **array**: tamaño fijo, admite tipos primitivos y complejos. índices o posiciones (desde 0 hasta length - 1)
  - **arrayList**: t dinámico, solo admite tipos complejos, métodos add, get, remove, size, y estructuras for,foreach

(Lo común es encontrar las listas declaradas como List e inicializadas como ArrayList o LinkedList para poder cambiar la implementación a posterior).  
<br>

- **PAR CLAVE-VALOR**
  - **HashMap**: t dinámico, asocia IDs con datos, solo admite tipos complejos, tiene métodos: put(K,V), get(K) y remove(K). Se puede recorrer iterando o bien sus claves o sus valores.  
    <br>

---

**POO -> 4 pilares:**

- **Encapsulación:** atributos private, interacc. Mediante getter / setter
- **Herencia**: se heredan variables (a excepc de las private, que irían con getter setter), atributos y métodos a excepc de los private y los constructores, pero estos últimos pueden llamarse usando super().
- **Polimorfismo:** Permite que objetos de diferentes clases hijas respondan al mismo método de manera distinta, o que una variable de la clase padre pueda referenciar a cualquier objeto de sus clases hijas.
- **Abstracción:** qué hace un objeto y NO cómo mostrando lo esencial y ocultando la complejidad.  
  <br>

---

**Interfaces: Se definen como public interface. Métodos abstractos (**solo nombre + retorno SIN CUERPO {}**. Atrib. Constantes.** Si una clase normal (no abstracta) usa **implements**, está **100% obligada** a sobreescribir el código de todos y cada uno de los métodos de la interfaz con @Override.  
<br>

---

**Funciones Stream:** procesan secuencias de datos. Permiten: filtrar (filter), ordenar (sort), transformar (map) o filtrar (filter).

**Expresiones Lambda:** parametro -> cuerpo. Si tiene una sola línea, return implícito; si abre llaves {}, debe escribirse explícitamente. Se usan mucho en flujos de datos (stream().map()).

**BiFunction**: recibe 2 argumentos y devuelve 1 resultado. Sirve para realizar Callbacks **(una función que usa otra como argumento) mediante .apply().**

**BiPredicate y BiConsumer**: 2 parámetros, se usan en filtros.

**Referencia a métodos:** sintaxis de acceso directo **(Clase::metodo)** que sustituye a las lambdas cuando no es necesario declarar parámetros.  
<br>

---

**Recursividad:** método se llama a sí mismo, consume mucha memoria, precisa "casos base" para detener las llamadas.  
<br>

---

**INGENIERÍA DE SOFTWARE:**  
<br>

- **FASES DE DESARROLLO:**
  - Planificar (pensar la solución).
  - Diseño (UML, wireframes-bocetos, diagramas de BBDD.
  - Codificación.
  - Pruebas.
  - Lanzamiento.
  - Mantenimiento.

- **OPTIMIZACIÓN**: Un buen código usa menos líneas (menos ciclos de CPU), reduce los accesos al disco y minimiza el uso de memoria RAM.

- **BUENAS** **PRÁCTICAS**: separar funcionalidades en distintos métodos, minimizar el uso de variables static, evitar anidar más de dos estructuras de repetición (bucles) y ser cuidadoso con el uso de return y break en iteraciones poco profundas.  
  <br>

---

**Excepciones**: errores que interrumpen el flujo del programa en ejecución. Se gestionan con la estructura try-catch-finally. El código que puede fallar se envuelve en el try, la respuesta al error va en el catch, y el finally se ejecuta siempre.

- Tipos: unchequed -> runtime / chequed -> IOException

La palabra throws en la firma de un método delega la resolución del error a quien llame a dicho método.  
<br>

---

**JSON**: Formato de texto ligero y fácil de leer tanto para humanos como para máquinas. Estructura datos en pares clave-valor. Extracc. De datos mediante **parseo con librerías Jackson o Gson.**  
<br>

---

**Maven vs Local:** En vez de descargar librerías e inyectarlas manualmente en IntelliJ (Local), Maven centraliza estas descargas bajo demanda en un servidor mediante un archivo llamado pom.xml.
