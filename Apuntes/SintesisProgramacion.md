## 1. Fundamentos de Programación y Estructuras de Control

**El ecosistema (JDK, JRE, JVM):** Escribes código usando las herramientas del **JDK** (Java Development Kit). Ese código se compila a un lenguaje intermedio llamado _Bytecode_. Luego, el **JRE** (Java Runtime Environment) provee las librerías base, y la **JVM** (Java Virtual Machine) es la máquina virtual que finalmente lee ese Bytecode y le da instrucciones a tu sistema operativo. Por eso Java es multiplataforma: la JVM se adapta a Windows, Mac o Linux.  
<br>

**Variables:** Son un espacio reservado para guardar datos reutilizables. Sus nombres deben ser representativos, escribirse en minúscula, ser únicos en su ámbito de vida (local o global) y no pueden contener palabras reservadas ni caracteres especiales. Las variables declaradas como constantes usan el modificador final, su valor no puede alterarse y su nombre va en MAYÚSCULAS.  
<br>

### Tipos de Datos

<br>

**Primitivos:** Solo almacenan el valor directamente en memoria. Incluyen enteros (byte, short, int, long), decimales (float, double), lógicos (boolean: true/false) y caracteres (char: carácter de 2 bytes para Unicode).

**Complejos:** Por cada tipo primitivo (que no tiene funcionalidades), el lenguaje proporciona un "tipo complejo" equivalente, que es un objeto, tiene métodos y se guarda en la memoria de forma diferente. Se usan mucho porque ciertas estructuras (como las Listas o ArrayList) no aceptan tipos primitivos, solo objetos.

- _int ➔_ **_Integer_**
- _double ➔_ **_Double_**
- _boolean ➔_ **_Boolean_**
- _char ➔_ **_Character_**
- _float ➔_ **_Float_**
- _byte ➔_ **_Byte_**
- _short ➔_ **_Short_**
- _long ➔_ **_Long_**  
  <br>

### Conversiones

<br>

- **Casteo:** Es la conversión de una variable de un tipo de dato a otro. Generalmente se usa para tipos primitivos (como pasar de decimal a entero) o entre objetos que comparten una jerarquía de herencia.
  - **Implícito:** automático, cuando no hay pérdida de información.
  - **Explícito:** forzado por el programador usando paréntesis, donde puede perderse precisión.
- **Parseo:** conversión de una cadena de texto (String) hacia un número, una fecha o un objeto JSON.
- **Autobox:** conversión automática que realiza el compilador para pasar de un tipo de dato primitivo a su correspondiente objeto o clase envoltorio.
- **Unbox:** proceso inverso al autoboxing.
- El "Casting" ocurre cuando los tipos encajan de forma natural (ej. un int que pasa a double).
- El "Parsing" es necesario cuando el cambio no es natural (ej. texto a número usando Integer.parseInt()) y puede fallar.  
  <br>

---

## 2. La Memoria: ¿Qué es el Stack y el Heap y cómo se accede?

Cuando el programa se ejecuta, la memoria RAM asignada se divide principalmente en dos zonas de trabajo: **El Stack (Pila)** y **El Heap (Montón)**. Entender esto es vital para saber la diferencia real entre tipos primitivos y complejos.  
<br>

### La Memoria Stack (Pila)

Es una memoria de tamaño fijo, muy ordenada y extremadamente rápida. Funciona bajo el principio LIFO (Último en entrar, primero en salir), como una pila de platos. Se usa para la ejecución del programa y las variables locales.

- **¿Qué guarda?:**
  - Las llamadas a las funciones/métodos.
  - **Los valores de los Tipos Primitivos** (un int, un boolean).
  - **Las Referencias** (direcciones de memoria) de los tipos complejos.
  - **Estados de ejecución** de métodos.
- **¿Cómo se accede?:** El acceso es **directo e inmediato**. El procesador sabe exactamente dónde está el dato en la pila. Cuando una función termina, sus variables en el Stack se borran automáticamente.  
  <br>

### La Memoria Heap (Montón o Montículo)

Es una gran "piscina" de memoria dinámica, mucho más grande pero algo más desorganizada y ligeramente más lenta que el Stack.

- **¿Qué guarda?:**
  - **Todos los Objetos (Tipos complejos / De referencia).** Cada vez que usas la palabra new, el sistema busca un hueco libre en el Heap, mete ahí el objeto y te devuelve la dirección.
- **¿Cómo se accede?:** El acceso es **indirecto**. El proceso es: el programa va al **Stack** a leer tu variable, encuentra una "dirección" y sigue esa dirección hasta el **Heap** para encontrar el objeto real.
- **¿Quién la limpia?:** Como es dinámica, no se limpia sola al acabar una función. De esto se encarga el **Garbage Collector (Recolector de Basura)**.  
  <br>

### Metaspace o Segmento de Código

Las instrucciones del código se cargan en esta zona (el código fuente de los métodos, las instrucciones lógicas, los if, los bucles, etc.). Esta zona es de **solo lectura**.

**La Memoria y la palabra static:** Cuando creas un objeto con new, Java le reserva un bloque de memoria (Heap). Sin embargo, cuando declaras una variable o método como static, este no va al Heap del objeto, sino a un espacio global de la clase. Por eso el patrón **Singleton** usa variables static para garantizar que toda la aplicación comparta el mismo recurso.  
<br>

---

## 3. Declaración-Instanciación-Inicialización

<br>

### Declaración (Crear la etiqueta)

Le dice al programa que va a necesitar un espacio para guardar algo y se le da un nombre.

- **En memoria:** Se reserva un hueco en el _Stack_ con el nombre de la variable, pero su valor es nulo (null).

### Instanciación (Crear la realidad)

Es cuando se **crea el objeto físico** en la memoria utilizando la palabra new.

- **En memoria:** Se reserva espacio en el _Heap_ para construir el objeto con todas sus propiedades.

### Inicialización (Conectar ambas cosas)

Es el acto de **asignar el objeto que se ha instanciado a la variable que ha declarado**. Se hace con el signo igual (=).

- **En memoria:** El hueco en el _Stack_ guarda la dirección de memoria de donde está el objeto en el _Heap_.  
  <br>

**Resumen:**

- **Declarar:** _"Quiero una variable que se llame X."_
- **Instanciar:** _"Fabrica un objeto real en la memoria."_
- **Inicializar:** _"Guarda ese objeto dentro de mi variable X."_  
  <br>

---

## 4. Operadores

<br>

- **Aritméticos:** Suma, resta, multiplicación, división y resto.
- **Relacionales:** Comparan valores (>, <, ==, !=) y devuelven un booleano.
- **Lógicos:** AND (&&) devuelve true solo si todas las condiciones lo son. OR (||) devuelve true si al menos una condición lo es.
  - **Operadores AND (&& y &):** El operador && trabaja a nivel booleano. El operador & realiza la misma función lógica, pero también puede operar a nivel de bits.
  - **Operadores OR (|| y |):** Este operador da como resultado TRUE cuando _al menos una_ de las condiciones es verdadera. El símbolo | hace lo propio a nivel de bits.  
    <br>

---

## 5. Control de Flujo

<br>

- **Selección:** **if/else** evalúa una condición booleana, mientras que **switch** evalúa el valor exacto de una variable.
- **Repetición:** **for** ejecuta un bloque un número predeterminado de veces. **while** evalúa la condición primero, mientras que **do-while** ejecuta primero y evalúa después.  
  <br>

- **Saltos de Flujo:** - **break ->** rompe la ejecución de la estructura de control. - **return ->** termina la ejecución del método. - **continue ->** salta una repetición en un bucle. - (En un método con tipo de retorno se ha de usar return OBLIGATORIAMENTE AL FINAL DEL MÉTODO).  
  <br>

---

## 6. Estructuras de Datos

<br>

- **Iterables**
  - **Array (Arreglo)**: Estructura básica, de tamaño fijo, una vez creado, no puede cambiar su longitud. Admite tanto tipos primitivos como objetos.
  - **ArrayList**: Implementación de una lista basada en un arreglo dinámico. Su tamaño se ajusta automáticamente al añadir o quitar elementos. Solo puede almacenar objetos (para primitivos se usan sus clases envolventes o _wrappers_ como Integer).
- **Clave-valor**
  - **HashMap**: Estructura de datos basada en diccionarios que almacena pares clave-valor. Permite búsquedas y accesos casi instantáneos utilizando la "clave" única para extraer su "valor" asociado.  
    <br>

---

## 7. Programación Orientada a Objetos (POO)

La POO nos permite crear el "molde" o estructura de un tipo de dato que tendrá una realidad individual.  
<br>

- **Clases y Objetos:** Una clase es la plantilla básica para instanciar objetos. El nombre de las clases debe escribirse en singular y la primera letra en mayúscula. Requiere un método main como puerta de entrada.
- **Encapsulamiento:** exige que los atributos sean privados (private). Para acceder a ellos es obligatorio implementar métodos públicos getter y setter.
- **Constructores y Métodos:** Los constructores indican cómo se inicializa un objeto. Los métodos son verbos que dotan de acciones al objeto.
- **Herencia y Polimorfismo:** La herencia (mediante extends) permite a una clase hija obtener propiedades de una clase padre. El polimorfismo es la capacidad de "vestir" de varias formas a un elemento.
- **Polimorfismo en profundidad:** Es la capacidad de que una variable de la clase Padre apunte a un objeto de la clase Hija, permitiendo crear código altamente flexible.
  - **ResultSet:** Objeto que recibe los resultados de una consulta SELECT. Se usa rs.next() para avanzar el puntero fila a fila.
- **Abstracción:** Centrarse en _qué_ hace un objeto en lugar de _cómo_ lo hace, ocultando la complejidad interna.
  <br>

---

## 8. Interfaces

Las interfaces permiten llevar al máximo la abstracción y polimorfismo. Son el nivel más puro de abstracción que existe en Java. No se pide escribir la palabra abstract al definirlas (`public interface`).

Son un **contrato 100% estricto** que define _qué_ acciones debe poder hacer una clase, pero no _cómo_. No se pueden instanciar, se usan mediante `implements`. Contienen:

- Métodos abstractos: Solo nombre y retorno SIN CUERPO `{}`.
- Atributos constantes (`public static final` POR DEFECTO).

Si una clase normal usa `implements`, está **100% obligada** a sobreescribir todos los métodos de la interfaz con `@Override`.
