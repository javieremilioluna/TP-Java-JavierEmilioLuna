import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Javier Emilio Luna
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int accion;
        String eleccion;
        Cartelera cartelera = new Cartelera();
        String textoInicio = "SISTEMA DE GESTIÓN 'CINEMAX' \n Seleccione la acción deseada (de acuerdo al nro. de la lista) o presione 0 (cero) para salir: \n " +
                "1 - VER PELÍCULAS CARGADAS \n 2 - AGREGAR PELÍCULA \n 3 - EDITAR PELÍCULA \n 4 - ELIMINAR PELÍCULA \n 5 - REPORTES SOBRE PELÍCULAS\n" +
                "---------------------------- \n 6 - VER LISTA DE EMPLEADOS \n 7 - AGREGAR EMPLEADO \n " +
                "8 - MODIFICAR EMPLEADO \n 9 - ELIMINAR EMPLEADO \n 10 - REPORTES SOBRE EMPLEADOS";
        String textoConsultaFinal = "¿DESEA REALIZAR OTRA ACCIÓN? Y = SI , N = NO";
        String textoListadoPeliculas = "Listado de Películas Cargadas: \n";
        String textoListadoEmpleados = "Listado de Empleados Cargados: \n";
        String gracias = "Muchas gracias!";

        //PELICULAS PRECARGADAS
        Pelicula pelicula1 = new Pelicula("Harry Potter", "20/01/2005", 2.10F);
        Pelicula pelicula2 = new Pelicula("El Señor de los Anillos", "20/01/2010", 2.50F);
        Pelicula pelicula3 = new Pelicula("El Rey León", "20/01/2005", 2.00F);

        cartelera.agregarPelicula(pelicula1);
        cartelera.agregarPelicula(pelicula2);
        cartelera.agregarPelicula(pelicula3);

        //EMPLEADOS PRECARGADOS
        Empleado empleado1 = new Empleado("Juan Hernández", 28, 2, "AAA254", "21/02/2018", 30F);
        Empleado empleado2 = new Empleado("Victoria Luna", 22, 1, "AAA290", "10/05/2019", 40F);
        Empleado empleado3 = new Empleado("Andrés Diaz", 25, 3, "AAA991", "21/09/2017", 45F);

        ArrayList<Empleado> empleados = new ArrayList();
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);

        System.out.println(textoInicio);

        accion = sc.nextInt();

        while (accion != 0) {
            if (accion == 1) {

                System.out.println(textoListadoPeliculas);

                //RECORRIDO DE ARREGLO CON FOR COMÚN
                for (int i = 0; i < cartelera.getPeliculas().size(); i++) {
                    System.out.println("Nro:" + cartelera.getPeliculas().indexOf(cartelera.getPeliculas().get(i)) +
                            " -> " + cartelera.getPeliculas().get(i).getNombre() + ", Fecha de estreno: "
                            + cartelera.getPeliculas().get(i).getFecha_estreno() + ", Duración: "
                            + cartelera.getPeliculas().get(i).getDuracion()
                    );
                }

                System.out.println("\n" + textoConsultaFinal);
                eleccion = sc.next();
                if (eleccion.equals("y") || eleccion.equals("Y")) {
                    System.out.println(textoInicio);
                    accion = sc.nextInt();
                } else {
                    System.out.println(gracias);
                    break;
                }
            } else if (accion == 2) {

                System.out.println("Cargar Pelicula: \n");
                System.out.println("Ingrese nombre de Pelicula: ");
                String nombre = sc.next();
                System.out.println("Ingrese la fecha de estreno de la pelicula (dd/mm/yyyy): ");
                String fecha = sc.next();
                System.out.println("Ingrese la duración de la pelicula (FORMATO= 02.30): ");
                String duracion = sc.next();

                Pelicula pelicula = new Pelicula(nombre, fecha, Float.parseFloat(duracion));
                cartelera.agregarPelicula(pelicula);
                System.out.println("Pelicula agregada con éxito! \n");
                System.out.println(textoListadoPeliculas);
                for (int i = 0; i < cartelera.getPeliculas().size(); i++) {
                    System.out.println("Nro:" + cartelera.getPeliculas().indexOf(cartelera.getPeliculas().get(i)) +
                            " -> " + cartelera.getPeliculas().get(i).getNombre() + ", Fecha de estreno: "
                            + cartelera.getPeliculas().get(i).getFecha_estreno() + ", Duración: "
                            + cartelera.getPeliculas().get(i).getDuracion()
                    );
                }

                System.out.println("\n" + textoConsultaFinal);
                eleccion = sc.next();
                if (eleccion.equals("y") || eleccion.equals("Y")) {
                    System.out.println(textoInicio);
                    accion = sc.nextInt();
                } else {
                    System.out.println(gracias);
                    break;
                }
            } else if (accion == 3) {

                int idPelicula;

                System.out.println("Modificar Peliculas: \n");
                for (int i = 0; i < cartelera.getPeliculas().size(); i++) {
                    System.out.println("Nro:" + cartelera.getPeliculas().indexOf(cartelera.getPeliculas().get(i)) +
                            " -> " + cartelera.getPeliculas().get(i).getNombre() + ", Fecha de estreno: "
                            + cartelera.getPeliculas().get(i).getFecha_estreno() + ", Duración: "
                            + cartelera.getPeliculas().get(i).getDuracion()
                    );
                }

                System.out.println("\n Ingrese el número de la película que desee modificar: ");
                idPelicula = sc.nextInt();

                System.out.println("Ingrese nuevo nombre de película Nro: " + idPelicula);
                String nombre = sc.next();
                cartelera.getPeliculas().get(idPelicula).setNombre(nombre);
                System.out.println("Ingrese nueva fecha de estreno de la película");
                String fecha = sc.next();
                cartelera.getPeliculas().get(idPelicula).setFecha_estreno(fecha);
                System.out.println("Ingrese nueva duración de la película (FORMATO= 02.30)");
                String duracion = sc.next();
                cartelera.getPeliculas().get(idPelicula).setDuracion(Float.parseFloat(duracion));

                System.out.println("Pelicula modificada con éxito! \n");
                System.out.println(textoListadoPeliculas);
                for (int i = 0; i < cartelera.getPeliculas().size(); i++) {
                    System.out.println("Nro:" + cartelera.getPeliculas().indexOf(cartelera.getPeliculas().get(i)) +
                            " -> " + cartelera.getPeliculas().get(i).getNombre() + ", Fecha de estreno: "
                            + cartelera.getPeliculas().get(i).getFecha_estreno() + ", Duración: "
                            + cartelera.getPeliculas().get(i).getDuracion()
                    );
                }

                System.out.println("\n" + textoConsultaFinal);
                eleccion = sc.next();
                if (eleccion.equals("y") || eleccion.equals("Y")) {
                    System.out.println(textoInicio);
                    accion = sc.nextInt();
                } else {
                    System.out.println(gracias);
                    break;

                }
            } else if (accion == 4) {

                int idPelicula;

                System.out.println("Eliminar Peliculas: \n");
                for (int i = 0; i < cartelera.getPeliculas().size(); i++) {
                    System.out.println("Nro:" + cartelera.getPeliculas().indexOf(cartelera.getPeliculas().get(i)) +
                            " -> " + cartelera.getPeliculas().get(i).getNombre() + ", Fecha de estreno: "
                            + cartelera.getPeliculas().get(i).getFecha_estreno() + ", Duración: "
                            + cartelera.getPeliculas().get(i).getDuracion()
                    );
                }

                System.out.println("Ingrese el número de la película que desee eliminar: ");
                idPelicula = sc.nextInt();

                cartelera.getPeliculas().remove(idPelicula);
                System.out.println("Película borrada con éxito! \n");

                System.out.println(textoListadoPeliculas);
                for (int i = 0; i < cartelera.getPeliculas().size(); i++) {
                    System.out.println("Nro:" + cartelera.getPeliculas().indexOf(cartelera.getPeliculas().get(i)) +
                            " -> " + cartelera.getPeliculas().get(i).getNombre() + ", Fecha de estreno: "
                            + cartelera.getPeliculas().get(i).getFecha_estreno() + ", Duración: "
                            + cartelera.getPeliculas().get(i).getDuracion()
                    );
                }

                System.out.println("\n" + textoConsultaFinal);
                eleccion = sc.next();
                if (eleccion.equals("y") || eleccion.equals("Y")) {
                    System.out.println(textoInicio);
                    accion = sc.nextInt();
                } else {
                    System.out.println(gracias);
                    break;
                }
            } else if (accion == 5) {

                System.out.println("Reportes: ");
                System.out.println("Cantidad de películas cargadas: " + cartelera.getPeliculas().size());
                System.out.println("Cantidad de películas con una duración mayor a 2 horas: " + cartelera.cantPeliculasConDuracionMayorA2Horas());
                System.out.println("Película con la menor duración: " + cartelera.peliculaMasCorta());

                System.out.println("\n" + textoConsultaFinal);
                eleccion = sc.next();
                if (eleccion.equals("y") || eleccion.equals("Y")) {
                    System.out.println(textoInicio);
                    accion = sc.nextInt();
                } else {
                    System.out.println(gracias);
                    break;
                }
            } else if (accion == 6) {

                System.out.println(textoListadoEmpleados);

                //USO DE FOREACH PARA RECORRER LA LISTA DE EMPLEADOS
                for (Empleado e : empleados) {
                    System.out.println("Nro: " + empleados.indexOf(e) +
                            " -> " + " Nombre y apellido: " + e.getNom_apellido() + ", Legajo: "
                            + e.getLegajo() + ", Fecha de alta: "
                            + e.getFecha_alta() + ", Edad: "
                            + e.getEdad() + ", Sexo: "
                            + e.determinarSexo() + ", Sueldo: "
                            + e.calcularSueldo());
                }


                System.out.println("\n" + textoConsultaFinal);
                eleccion = sc.next();
                if (eleccion.equals("y") || eleccion.equals("Y")) {
                    System.out.println(textoInicio);
                    accion = sc.nextInt();
                } else {
                    System.out.println(gracias);
                    break;
                }
            } else if (accion == 7) {

                System.out.println("Cargar Empleado:");
                System.out.println(Empleado.mostrarAyudaSobreAltas()); //USO DE MÉTODO ESTÁTICO
                System.out.println("Ingrese nombre de empleado: ");
                String nombre = sc.next();
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

                Empleado empleado = new Empleado(nombre, edad, sexo, legajo, fec_alta,Float.parseFloat(horas));
                empleados.add(empleado);

                System.out.println("Empleado agregado con éxito! \n");
                System.out.println(textoListadoEmpleados);

                for (Empleado e : empleados) {
                    System.out.println("Nro: " + empleados.indexOf(e) +
                            " -> " + " Nombre y apellido: " + e.getNom_apellido() + ", Legajo: "
                            + e.getLegajo() + ", Fecha de alta: "
                            + e.getFecha_alta() + ", Edad: "
                            + e.getEdad() + ", Sexo: "
                            + e.determinarSexo() + ", Sueldo: "
                            + e.calcularSueldo());
                }

                System.out.println("\n" + textoConsultaFinal);
                eleccion = sc.next();
                if (eleccion.equals("y") || eleccion.equals("Y")) {
                    System.out.println(textoInicio);
                    accion = sc.nextInt();
                } else {
                    System.out.println(gracias);
                    break;
                }
            } else if (accion == 8) {

                int idEmpleado;
                System.out.println("Modificar Empleados: \n");
                for (Empleado e : empleados) {
                    System.out.println("Nro: " + empleados.indexOf(e) +
                            " -> " + " Nombre y apellido: " + e.getNom_apellido() + ", Legajo: "
                            + e.getLegajo() + ", Fecha de alta: "
                            + e.getFecha_alta() + ", Edad: "
                            + e.getEdad() + ", Sexo: "
                            + e.determinarSexo() + ", Sueldo: "
                            + e.calcularSueldo());
                }

                System.out.println("\nIngrese el número de empleado que desee modificar: ");
                idEmpleado = sc.nextInt();

                System.out.println("Ingrese nuevo nombre de empleado Nro: " + idEmpleado);
                String nombre = sc.next();
                empleados.get(idEmpleado).setNom_apellido(nombre);
                System.out.println("Ingrese nuevo legajo de empleado: ");
                String legajo = sc.next();
                empleados.get(idEmpleado).setLegajo(legajo);
                System.out.println("Ingrese nueva fecha de alta: ");
                String fec_alta = sc.next();
                empleados.get(idEmpleado).setFecha_alta(fec_alta);
                System.out.println("Ingrese nueva edad de empleado: ");
                String edad = sc.next();
                empleados.get(idEmpleado).setEdad(Integer.parseInt(edad));
                System.out.println("Ingrese sexo de empleado: ");
                String sexo = sc.next();
                empleados.get(idEmpleado).setSexo(Integer.parseInt(sexo));
                System.out.println("Ingrese cantidad de horas semanales: ");
                String cant_horas = sc.next();
                empleados.get(idEmpleado).setCant_horas_trabajo(Float.parseFloat(cant_horas));

                System.out.println("Empleado modificado con éxito! \n");
                System.out.println(textoListadoEmpleados);

                for (Empleado e : empleados) {
                    System.out.println("Nro: " + empleados.indexOf(e) +
                            " -> " + " Nombre y apellido: " + e.getNom_apellido() + ", Legajo: "
                            + e.getLegajo() + ", Fecha de alta: "
                            + e.getFecha_alta() + ", Edad: "
                            + e.getEdad() + ", Sexo: "
                            + e.determinarSexo() + ", Sueldo: "
                            + e.calcularSueldo());
                }

                System.out.println("\n" + textoConsultaFinal);
                eleccion = sc.next();
                if (eleccion.equals("y") || eleccion.equals("Y")) {
                    System.out.println(textoInicio);
                    accion = sc.nextInt();
                } else {
                    System.out.println(gracias);
                    break;

                }
            } else if (accion == 9) {
                int idEmpleado;
                System.out.println("Eliminar Empleados: \n");

                for (Empleado e : empleados) {
                    System.out.println("Nro: " + empleados.indexOf(e) +
                            " -> " + " Nombre y apellido: " + e.getNom_apellido() + ", Legajo: "
                            + e.getLegajo() + ", Fecha de alta: "
                            + e.getFecha_alta() + ", Edad: "
                            + e.getEdad() + ", Sexo: "
                            + e.determinarSexo() + ", Sueldo: "
                            + e.calcularSueldo());
                }

                System.out.println("Ingrese el número de empleado que desee eliminar: ");
                idEmpleado = sc.nextInt();

                empleados.remove(idEmpleado);
                System.out.println("Empleado borrado con éxito! \n");
                System.out.println(textoListadoEmpleados);

                for (Empleado e : empleados) {
                    System.out.println("Nro: " + empleados.indexOf(e) +
                            " -> " + " Nombre y apellido: " + e.getNom_apellido() + ", Legajo: "
                            + e.getLegajo() + ", Fecha de alta: "
                            + e.getFecha_alta() + ", Edad: "
                            + e.getEdad() + ", Sexo: "
                            + e.determinarSexo() + ", Sueldo: "
                            + e.calcularSueldo());
                }

                System.out.println("\n" + textoConsultaFinal);
                eleccion = sc.next();
                if (eleccion.equals("y") || eleccion.equals("Y")) {
                    System.out.println(textoInicio);
                    accion = sc.nextInt();
                } else {
                    System.out.println(gracias);
                    break;
                }
            } else if (accion == 10) {

                double acumulador = 0;
                System.out.println("Reportes: ");
                System.out.println("Cantidad de empleados cargados: " + empleados.size());

                for (Empleado e : empleados) {
                    acumulador += e.calcularSueldo();
                }
                System.out.println("Promedio de sueldos en pesos: $" + acumulador / empleados.size());

                System.out.println("\n" + textoConsultaFinal);
                eleccion = sc.next();
                if (eleccion.equals("y") || eleccion.equals("Y")) {
                    System.out.println(textoInicio);
                    accion = sc.nextInt();
                } else {
                    System.out.println(gracias);
                    break;
                }
            } else {
                System.out.println(textoInicio);
                System.out.println("Ingrese un número válido o presione 0 para salir. \n");
                accion = sc.nextInt();
            }
        }

    }
}

