import cartelera.Pelicula;
import gestorBD.GestorBD;
import rrhh.Empleado;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Javier Emilio Luna
 */

public class Main {
    public static void main(String[] args) {

        GestorBD gestor = new GestorBD();
        Scanner sc = new Scanner(System.in);
        int accion;
        String eleccion;
        int idPelicula;
        int idEmpleado;

        /*EJECUTAR SÓLO UNA VEZ PARA CREAR LAS TABLAS Y CARGAR LOS DATOS INICIALES. DESPUÉS DE LA PRIMERA EJECUCIÓN ES
        NECESARIO COMENTAR LAS LINEAS DE: "gestor.crearTablaPeliculas();gestor.agregarPeliculasIniciales();gestor.crearTablaEmpleados();
        gestor.agregarEmpleadosIniciales();" PARA EVITAR QUE VUELVAN A CREARSE LAS TABLAS Y SE DUPLIQUEN LOS DATOS DE EJEMPLO.*/

        gestor.crearTablaPeliculas();
        gestor.agregarPeliculasIniciales();
        gestor.crearTablaEmpleados();
        gestor.agregarEmpleadosIniciales();

        //////////////////////////////////////////////////////////////////////////


        String textoInicio = "SISTEMA DE GESTIÓN 'CINEMAX' \n Seleccione la acción deseada (de acuerdo al nro. de la lista) o presione 0 (cero) para salir: \n " +
                "1 - VER PELÍCULAS CARGADAS \n 2 - AGREGAR PELÍCULA \n 3 - EDITAR PELÍCULA \n 4 - ELIMINAR PELÍCULA \n 5 - REPORTES SOBRE PELÍCULAS\n" +
                "---------------------------- \n 6 - VER LISTA DE EMPLEADOS \n 7 - AGREGAR EMPLEADO \n " +
                "8 - MODIFICAR EMPLEADO \n 9 - ELIMINAR EMPLEADO \n 10 - REPORTES SOBRE EMPLEADOS \nIngrese opción: ";
        String textoConsultaFinal = "¿DESEA REALIZAR OTRA ACCIÓN? Y = SI , N = NO";
        String textoListadoPeliculas = "Listado de Películas Cargadas: \n";
        String textoListadoEmpleados = "Listado de Empleados Cargados: \n";
        String gracias = "Muchas gracias!";

        System.out.println(textoInicio);
        accion = sc.nextInt();

        while (accion != 0) {

            switch (accion) {

                case 1:

                    System.out.println(textoListadoPeliculas);
                    gestor.obtenerPeliculas();

                    System.out.println("\n" + textoConsultaFinal);
                    eleccion = sc.next();
                    if (eleccion.equals("y") || eleccion.equals("Y")) {
                        System.out.println(textoInicio);
                        accion = sc.nextInt();
                    } else {
                        System.out.println(gracias);
                        accion = 0;
                    }
                    break;

                case 2:

                    System.out.println("Cargar Película: \n");

                    sc.nextLine();
                    System.out.println("Ingrese nombre de Película: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese la fecha de estreno de la película (dd/mm/yyyy): ");
                    String fecha = sc.next();
                    System.out.println("Ingrese la duración de la película (FORMATO= 02.30): ");
                    String duracion = sc.next();

                    Pelicula p = new Pelicula(nombre, fecha, Float.parseFloat(duracion));
                    gestor.agregarPelicula(p);

                    System.out.println("Película agregada con éxito! \n");

                    System.out.println(textoListadoPeliculas);
                    gestor.obtenerPeliculas();

                    System.out.println("\n" + textoConsultaFinal);
                    eleccion = sc.next();
                    if (eleccion.equals("y") || eleccion.equals("Y")) {
                        System.out.println(textoInicio);
                        accion = sc.nextInt();
                    } else {
                        System.out.println(gracias);
                        accion = 0;
                    }
                    break;


                case 3:

                    System.out.println("Modificar Peliculas: \n");
                    gestor.obtenerPeliculas();

                    System.out.println("\nIngrese el número de la película que desee modificar: ");
                    idPelicula = sc.nextInt();

                    sc.nextLine();
                    System.out.println("Ingrese nuevo nombre de película Nro: " + idPelicula);
                    String nuevoNombre = sc.nextLine();
                    System.out.println("Ingrese nueva fecha de estreno de la película");
                    String nuevaFecha = sc.next();
                    System.out.println("Ingrese nueva duración de la película (FORMATO= 02.30)");
                    String nuevaDuracion = sc.next();

                    Pelicula p1 = new Pelicula(nuevoNombre, nuevaFecha, Float.parseFloat(nuevaDuracion));
                    p1.setId(idPelicula);
                    gestor.modificarPelicula(p1);

                    System.out.println("Película modificada con éxito! \n");
                    System.out.println(textoListadoPeliculas);
                    gestor.obtenerPeliculas();

                    System.out.println("\n" + textoConsultaFinal);
                    eleccion = sc.next();
                    if (eleccion.equals("y") || eleccion.equals("Y")) {
                        System.out.println(textoInicio);
                        accion = sc.nextInt();
                    } else {
                        System.out.println(gracias);
                        accion = 0;
                    }
                    break;


                case 4:

                    System.out.println("Eliminar Peliculas: \n");
                    gestor.obtenerPeliculas();

                    System.out.println("Ingrese el número de la película que desee eliminar: ");
                    idPelicula = sc.nextInt();

                    gestor.eliminarPelicula(idPelicula);
                    System.out.println("Película borrada con éxito! \n");

                    System.out.println(textoListadoPeliculas);
                    gestor.obtenerPeliculas();

                    System.out.println("\n" + textoConsultaFinal);
                    eleccion = sc.next();
                    if (eleccion.equals("y") || eleccion.equals("Y")) {
                        System.out.println(textoInicio);
                        accion = sc.nextInt();
                    } else {
                        System.out.println(gracias);
                        accion = 0;
                    }
                    break;

                case 5:

                    System.out.println("Reportes: ");
                    System.out.println("Cantidad de películas cargadas: " + gestor.obtenerPeliculasConArray().size());
                    System.out.println("Cantidad de películas con una duración mayor a 2 horas: " + gestor.cantPeliculasDuracMay2Horas());
                    System.out.println("Película con la menor duración: " + gestor.peliculaMenorDuracion());

                    System.out.println("\n" + textoConsultaFinal);
                    eleccion = sc.next();
                    if (eleccion.equals("y") || eleccion.equals("Y")) {
                        System.out.println(textoInicio);
                        accion = sc.nextInt();
                    } else {
                        System.out.println(gracias);
                        accion = 0;
                    }
                    break;

                case 6:

                    System.out.println(textoListadoEmpleados);
                    gestor.obtenerEmpleados();

                    System.out.println("\n" + textoConsultaFinal);
                    eleccion = sc.next();
                    if (eleccion.equals("y") || eleccion.equals("Y")) {
                        System.out.println(textoInicio);
                        accion = sc.nextInt();
                    } else {
                        System.out.println(gracias);
                        accion = 0;
                    }
                    break;

                case 7:

                    System.out.println("Cargar Empleado:");
                    System.out.println(Empleado.mostrarAyudaSobreAltas()); //USO DE MÉTODO ESTÁTICO

                    sc.nextLine();
                    System.out.println("Ingrese nombre de empleado: ");
                    String nombreEmpleado = sc.nextLine();
                    System.out.println("Ingrese legajo de empleado: ");
                    String legajo = sc.next();
                    System.out.println("Ingrese fecha alta de empleado (dd/mm/yyyy)");
                    String fec_alta = sc.next();
                    System.out.println("Ingrese edad de empleado: ");
                    int edad = sc.nextInt();
                    System.out.println("Ingrese sexo de empleado: (1:Mujer, 2: Hombre, 3:Otro): ");
                    int sexo = sc.nextInt();
                    System.out.println("Ingrese cantidad de horas semanales (FORMATO 25.5): ");
                    String horas = sc.next();

                    Empleado empleado = new Empleado(nombreEmpleado, edad, sexo, legajo, fec_alta, Float.parseFloat(horas));
                    gestor.agregarEmpleado(empleado);

                    System.out.println("Empleado agregado con éxito! \n");
                    System.out.println(textoListadoEmpleados);
                    gestor.obtenerEmpleados();

                    System.out.println("\n" + textoConsultaFinal);
                    eleccion = sc.next();
                    if (eleccion.equals("y") || eleccion.equals("Y")) {
                        System.out.println(textoInicio);
                        accion = sc.nextInt();
                    } else {
                        System.out.println(gracias);
                        accion = 0;
                    }
                    break;


                case 8:

                    System.out.println("Modificar Empleados: \n");
                    gestor.obtenerEmpleados();

                    System.out.println("\nIngrese el número de empleado que desee modificar: ");
                    idEmpleado = sc.nextInt();

                    sc.nextLine();
                    System.out.println("Ingrese nuevo nombre de empleado Nro: " + idEmpleado);
                    String nuevoNombreEmpleado = sc.nextLine();
                    System.out.println("Ingrese nuevo legajo de empleado: ");
                    String nuevoLegajo = sc.next();
                    System.out.println("Ingrese nueva fecha de alta: ");
                    String nuevaFecAlta = sc.next();
                    System.out.println("Ingrese nueva edad de empleado: ");
                    String nuevaEdad = sc.next();
                    System.out.println("Ingrese sexo de empleado: ");
                    String nuevoSexo = sc.next();
                    System.out.println("Ingrese cantidad de horas semanales: ");
                    String cant_horas = sc.next();

                    Empleado e = new Empleado(nuevoNombreEmpleado, Integer.parseInt(nuevaEdad), Integer.parseInt(nuevoSexo), nuevoLegajo, nuevaFecAlta, Float.parseFloat(cant_horas));
                    e.setId(idEmpleado);
                    gestor.modificarEmpleado(e);

                    System.out.println("Empleado modificado con éxito! \n");
                    System.out.println(textoListadoEmpleados);
                    gestor.obtenerEmpleados();

                    System.out.println("\n" + textoConsultaFinal);
                    eleccion = sc.next();
                    if (eleccion.equals("y") || eleccion.equals("Y")) {
                        System.out.println(textoInicio);
                        accion = sc.nextInt();
                    } else {
                        System.out.println(gracias);
                        accion = 0;
                    }
                    break;


                case 9:

                    System.out.println("Eliminar Empleados: \n");
                    gestor.obtenerEmpleados();

                    System.out.println("Ingrese el número de empleado que desee eliminar: ");
                    idEmpleado = sc.nextInt();

                    gestor.eliminarEmpleado(idEmpleado);
                    System.out.println("Empleado borrado con éxito! \n");
                    System.out.println(textoListadoEmpleados);
                    gestor.obtenerEmpleados();

                    System.out.println("\n" + textoConsultaFinal);
                    eleccion = sc.next();
                    if (eleccion.equals("y") || eleccion.equals("Y")) {
                        System.out.println(textoInicio);
                        accion = sc.nextInt();
                    } else {
                        System.out.println(gracias);
                        accion = 0;
                    }
                    break;


                case 10:

                    System.out.println("Reportes: ");
                    ArrayList<Empleado> empleados = gestor.obtenerEmpleadosConArray();
                    System.out.println("Cantidad de empleados cargados: " + empleados.size());

                    double acumulador = 0;
                    for (Empleado e2 : empleados) {
                        acumulador += e2.calcularSueldo();
                    }
                    System.out.println("Promedio de sueldos en pesos: $" + acumulador / empleados.size());

                    System.out.println("\n" + textoConsultaFinal);
                    eleccion = sc.next();
                    if (eleccion.equals("y") || eleccion.equals("Y")) {
                        System.out.println(textoInicio);
                        accion = sc.nextInt();
                    } else {
                        System.out.println(gracias);
                        accion = 0;
                    }
                    break;

                default:
                    System.out.println(textoInicio);
                    System.out.println("Ingrese un número válido o presione 0 para salir. \n");
                    accion = sc.nextInt();

            }
        }
    }
}

