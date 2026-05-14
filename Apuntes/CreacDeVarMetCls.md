## Formas de crear variables, clases y métodos

En Java, es fundamental hacer una distinción técnica: **solo los métodos tienen "firma" (signature)**. Las variables y las clases se definen exclusivamente mediante **declaraciones (declarations)**.

A continuación, se detalla la estructura para crear cada uno de estos elementos:  
<br>

**VARIABLES (DECLARACIÓN)**

Las variables no tienen firma. Su declaración le indica al compilador cómo se llama y qué tipo de datos va a almacenar. Una declaración de atributo de clase puede contener hasta 4 componentes:

- **Modificadores \[Opcionales\]:** \* _De acceso:_ private, protected, public.
  - _De comportamiento:_ static, final, transient, volatile.
- **Tipo de Dato \[Obligatorio\]:** Primitivos (ej. int, boolean) o Clases/Referencias (ej. String, List).
- **Nombre de la Variable \[Obligatorio\]:** El identificador, escrito por convención en camelCase.
- **Inicialización \[Opcional\]:** Operador de asignación = seguido del valor inicial o la creación del objeto con new, finalizado en ;  
  <br>

**CLASES (DECLARACIÓN)**

La declaración de una clase define el "molde" y su relación con otras partes del ecosistema. En su versión más compleja consta de 7 componentes:

- **Modificadores \[Opcionales\]:** public, abstract, final, strictfp (y anotaciones).
- **Palabra reservada class \[Obligatorio\]:** Indica al compilador qué estructura se está creando.
- **Nombre de la Clase \[Obligatorio\]:** El identificador, escrito por convención en PascalCase.
- **Parámetros de Tipo / Genéricos \[Opcionales\]:** Definidos entre &lt; &gt;.
- **Superclase \[Opcional\]:** La palabra extends seguida de una única clase padre.
- **Interfaces \[Opcionales\]:** La palabra implements seguida de una o más interfaces separadas por comas.
- **Cuerpo de la Clase \[Obligatorio\]:** Todo el código encerrado entre llaves { }.  
  <br>

**MÉTODOS - FIRMA Y DECLARACIÓN**

Para crear un método, se utiliza una **Declaración** completa (de hasta 7 componentes), dentro de la cual se encuentra incrustada su **Firma**.  
<br>

**Firma (Signature)**

Es el identificador único del método dentro de una clase, utilizado por el compilador para distinguir un método de otro (vital para la sobrecarga o _Overloading_).

- **INCLUYE:** El nombre del método, el número de parámetros, y el tipo de dato de los parámetros con su orden.
- **EXCLUYE:** El tipo de retorno, los modificadores de acceso y las excepciones (throws).  
  <br>

**Declaración**

En orden de aparición, los 7 componentes que forman la línea completa del método son:

- **Modificadores \[Opcionales\]:** De acceso (public, protected, private) y de comportamiento (static, final, abstract, synchronized, native, strictfp).
- **Parámetros de Tipo / Genéricos \[Opcionales\]:** Declarados entre corchetes angulares (ej. &lt;T&gt;).
- **Tipo de Retorno \[Obligatorio\]:** El tipo de dato a devolver o la palabra void.
- **Nombre del Método \[Obligatorio\]:** El identificador. _(Aquí empieza la firma)._
- **Lista de Parámetros \[Obligatorio\]:** Entre paréntesis (), con el tipo y nombre de cada argumento separados por comas. _(Aquí termina la firma)._
- **Lista de Excepciones \[Opcional\]:** La palabra throws seguida de las excepciones que podría lanzar.
- **Cuerpo del Método \[Obligatorio\]:** Todo el código encerrado entre { }.
  - _\*Excepción:_ Si el método es abstract o pertenece a una interfaz (pre-Java 8), no tiene cuerpo y termina en ;
