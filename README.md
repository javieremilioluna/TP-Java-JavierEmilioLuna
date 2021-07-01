# Java PIL - Trabajo Práctico - Javier Emilio Luna
## Documentación
### Temas y características del lenguaje Java usados:

### - PRIMERA ENTREGA
En el desarrollo de la primera parte de ésta app se utilizaron los conceptos pertenecientes a los módulos I a IV.
- **POO** (encapsulamiento, herencia, composición, polimorfismo, abstracción, clases abtractas,concretas y estáticas, métodos de instancia y estáticos).
- **ArrayList** como colección de datos para simplificar la manipulación de los objetos almacenados en ella.
- **Estructuras condicionales**.
- **Bucles** (for, foreach, while).
- **Clase Scanner** para el ingreso por consola de los datos y poder interactuar con el programa.

### - SEGUNDA ENTREGA
- Se modificó el funcionamiento interno de la app. No se agregaron nuevas funciones por lo que el modo de usar la aplicación se mantiene. <br>
- Se agregó **persistencia de datos** utilizando H2 como sistema administrador de base de datos embebido en la aplicación. <br>
- Se agregaron las correciones a la primera entrega.

## GUÍA DE USUARIO - SISTEMA DE GESTIÓN 'CINEMAX'
**1. INICIO - MENÚ PRINCIPAL** <br>
Al ingresar al sistema se muestra la lista de opciones disponibles: <br>
```
1 - VER PELÍCULAS CARGADAS
2 - AGREGAR PELÍCULA
3 - EDITAR PELÍCULA
4 - ELIMINAR PELÍCULA
5 - REPORTES SOBRE PELÍCULAS
----------------------------
6 - VER LISTA DE EMPLEADOS
7 - AGREGAR EMPLEADO
8 - MODIFICAR EMPLEADO
9 - ELIMINAR EMPLEADO
10 - REPORTES SOBRE EMPLEADOS
```
Seleccione la opción deseada ingresando el número correspondiente a cada operación para visualizar los submenús o presione 0 (cero) para salir del programa.

**2. NAVEGANDO POR LOS SUBMENÚS - GESTIÓN PELÍCULAS** 
```
1 - VER PELÍCULAS CARGADAS
```
Muestra la lista completa de las películas disponibles en cartelera.<br>
Para continuar operando y regresar al menú principal ingrese el comando "y" o "Y", en cambio si desea cerrar el programa
ingrese el comando "n" ó "N".

```
2 - AGREGAR PELÍCULA
```
Permite agregar una nueva película a la cartelera. Deberá ingresar los siguientes datos (todos obligatorios):<br>
- Nombre de la película.
- Fecha de estreno, con formato (dd/mm/yyyy).
- Duración de la película, con formato (02.30).

Si la película fue cargada correctamente aparecerá el mensaje "Pelicula agregada con éxito!".

Para continuar operando y regresar al menú principal ingrese el comando "y" o "Y", en cambio si desea cerrar el programa
ingrese el comando "n" ó "N".

```
3 - EDITAR PELÍCULA
```
Permite modificar los datos de una película ya cargada, para ello ingrese el número de película que desea modificar y
a continuación deberá reingresar los siguientes datos (todos obligatorios):<br>
- Nombre de la película.
- Fecha de estreno, con formato (dd/mm/yyyy).
- Duración de la película, con formato (02.30).

Si la película fue modificada correctamente aparecerá el mensaje "Pelicula modificada con éxito!".

Para continuar operando y regresar al menú principal ingrese el comando "y" o "Y", en cambio si desea cerrar el programa
ingrese el comando "n" ó "N".
```
4 - ELIMINAR PELÍCULA
```
Permite eliminar de cartelera alguna de las películas cargadas, para ello deberá ingresar el número de película que desea eliminar y presionar ENTER para confirmar.

Si la película fue eliminada correctamente aparecerá el mensaje "Pelicula borrada con éxito!".

Para continuar operando y regresar al menú principal ingrese el comando "y" o "Y", en cambio si desea cerrar el programa
ingrese el comando "n" ó "N".
```
5 - REPORTES SOBRE PELÍCULAS
```
Aquí se muestra la lista de reportes disponibles, los cuales incluyen información estadística sobre las películas disponibles en cartelera.
<br>Reportes disponibles: 
- Cantidad de películas cargadas.
- Cantidad de películas con una duración mayor a 2 horas.
- Película con la menor duración.
  
Para continuar operando y regresar al menú principal ingrese el comando "y" o "Y", en cambio si desea cerrar el programa
ingrese el comando "n" ó "N".

--------------------
**3. NAVEGANDO POR LOS SUBMENÚS - GESTIÓN EMPLEADOS**
```
6 - VER LISTA DE EMPLEADOS
```
Muestra la lista completa de los empleados que actualmente trabajan en la empresa.<br>
Para continuar operando y regresar al menú principal ingrese el comando "y" o "Y", en cambio si desea cerrar el programa
ingrese el comando "n" ó "N".

```
7 - AGREGAR EMPLEADO
```
Permite agregar un nuevo empleado a la empresa. Deberá ingresar los siguientes datos (todos obligatorios):<br>
- Nombre y apellido del empleado. 
- Legajo.
- Fecha de alta.
- Edad.
- Sexo (1:Mujer, 2: Hombre, 3:Otro).
- Cantidad de horas semanales que trabaja.

Si el empleado fue cargado correctamente aparecerá el mensaje "Empleado agregado con éxito!".

Para continuar operando y regresar al menú principal ingrese el comando "y" o "Y", en cambio si desea cerrar el programa
ingrese el comando "n" ó "N".

```
8 - MODIFICAR EMPLEADO
```
Permite modificar los datos de un empleado cargado, para ello ingrese el número de empleado que desea modificar y
a continuación deberá reingresar los siguientes datos (todos obligatorios):<br>
- Nombre y apellido del empleado.
- Legajo.
- Fecha de alta.
- Edad.
- Sexo (1:Mujer, 2: Hombre, 3:Otro).
- Cantidad de horas semanales que trabaja.

Si el empleado fue modificado correctamente aparecerá el mensaje "Empleado modificado con éxito!".

Para continuar operando y regresar al menú principal ingrese el comando "y" o "Y", en cambio si desea cerrar el programa
ingrese el comando "n" ó "N".

```
9 - ELIMINAR EMPLEADO
```
Permite eliminar a un empleado cargado, para ello deberá ingresar el número de empleado que desea eliminar y presionar ENTER para confirmar.

Si el empleado fue eliminado correctamente aparecerá el mensaje "Empleado borrado con éxito!".

Para continuar operando y regresar al menú principal ingrese el comando "y" o "Y", en cambio si desea cerrar el programa
ingrese el comando "n" ó "N".
```
10 - REPORTES SOBRE EMPLEADOS
```
Aquí se muestra la lista de reportes disponibles, los cuales incluyen información estadística sobre los empleados que trabajan en la empresa.
<br>Reportes disponibles:
- Cantidad de empleados cargados.
- Promedio de sueldos en pesos. 
  
Para continuar operando y regresar al menú principal ingrese el comando "y" o "Y", en cambio si desea cerrar el programa
ingrese el comando "n" ó "N".
