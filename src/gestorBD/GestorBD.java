package gestorBD;

import cartelera.Pelicula;
import rrhh.Empleado;
import java.sql.*;
import java.util.ArrayList;

public class GestorBD {

    Connection conn;
    Statement st;
    ResultSet rs;

    //MÉTODO GENÉRICO PARA ABRIR LA CONEXIÓN CON LA BASE DE DATOS
    private void abrirConexion() {
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa","");
            st = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //GESTIÓN PELÍCULAS

    //ÉSTE MÉTODO FUE GENERADO PARA SER UTILIZADO SÓLO UNA VEZ PARA CREAR LA TABLA "PELICULAS"
    public void crearTablaPeliculas()
    {
        try {
            abrirConexion();
            String sql =  "CREATE TABLE PELICULAS (ID INTEGER AUTO_INCREMENT, NOMBRE VARCHAR(50),FECHA_ESTRENO VARCHAR(50),DURACION FLOAT)";
            st.executeUpdate(sql);

            st.close();
            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //ÉSTE MÉTODO FUE GENERADO PARA SER UTILIZADO SÓLO UNA VEZ PARA AGREGAR PELÍCULAS DE EJEMPLO A LA TABLA "PELICULAS"
    public void agregarPeliculasIniciales() {

        try {
            abrirConexion();

            String sql = "INSERT INTO PELICULAS (NOMBRE, FECHA_ESTRENO, DURACION) VALUES ('Harry Potter y las Reliquias de la Muerte', '15/02/2010', 2.5)";
            st.executeUpdate(sql);

            sql = "INSERT INTO PELICULAS (NOMBRE, FECHA_ESTRENO, DURACION) VALUES ('El Señor de los Anillos', '20/01/2010', 2.4)";
            st.executeUpdate(sql);

            sql = "INSERT INTO PELICULAS (NOMBRE, FECHA_ESTRENO, DURACION) VALUES ('El Rey León', '05/09/2005', 2.0)";
            st.executeUpdate(sql);

            sql = "INSERT INTO PELICULAS (NOMBRE, FECHA_ESTRENO, DURACION) VALUES ('Black Widow', '08/05/2021', 2.5)";
            st.executeUpdate(sql);

            st.close();
            conn.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void obtenerPeliculas() {

        try {
            abrirConexion();
            rs = st.executeQuery("SELECT * FROM PELICULAS");
            while (rs.next()) {
                System.out.println("Nro. " + rs.getInt("id") + " -> " + rs.getString("nombre") + ", Fecha de estreno: " +
                        rs.getString("fecha_estreno") + ", Duración: " + rs.getFloat("duracion"));
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Pelicula> obtenerPeliculasConArray() {
        ArrayList<Pelicula> lista = new ArrayList<Pelicula>();
        try {
            abrirConexion();
            ResultSet rs = st.executeQuery("SELECT * FROM PELICULAS");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String fecha_estreno = rs.getString("fecha_estreno");
                float duracion = rs.getFloat("duracion");

                Pelicula p = new Pelicula(id, nombre, fecha_estreno, duracion);
                lista.add(p);
            }
            rs.close();
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return lista;
    }

    public void agregarPelicula(Pelicula p) {
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO PELICULAS ( nombre, fecha_estreno, duracion  ) VALUES (?, ?, ?)");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getFechaEstreno());
            ps.setFloat(3, p.getDuracion());

            ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void modificarPelicula(Pelicula p) {
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("UPDATE PELICULAS SET  nombre =  ? ,fecha_estreno= ? , duracion=?  WHERE id = ?");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getFechaEstreno());
            ps.setFloat(3, p.getDuracion());
            ps.setInt(4, p.getId());
            ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void eliminarPelicula(int id) {
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("DELETE PELICULAS WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public int cantPeliculasDuracMay2Horas() {

        int cantidad = 0;
        try {
            abrirConexion();
            rs = st.executeQuery("SELECT COUNT(*) AS CANTIDAD FROM PELICULAS WHERE DURACION > 2");
            if (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cantidad;
    }


    public Pelicula peliculaMenorDuracion() {

        Pelicula p = null;
        try {
            abrirConexion();
            rs = st.executeQuery("SELECT * FROM PELICULAS ORDER BY DURACION LIMIT 1 OFFSET 0");
            if (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String fecha_estreno = rs.getString("fecha_estreno");
                float duracion = rs.getFloat("duracion");

                p = new Pelicula(id, nombre, fecha_estreno, duracion);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }


    //GESTIÓN EMPLEADOS
    //ÉSTE MÉTODO FUE GENERADO PARA SER UTILIZADO SÓLO UNA VEZ PARA CREAR LA TABLA "EMPLEADOS"
    public void crearTablaEmpleados()
    {
        try {
            abrirConexion();
            String sql =  "CREATE TABLE EMPLEADOS (ID INTEGER AUTO_INCREMENT, NOMBRE VARCHAR(50), EDAD INTEGER,SEXO INTEGER,LEGAJO VARCHAR(50), FECHA_ALTA VARCHAR(50), " +
                    "cant_horas_trabajo FLOAT)";
            st.executeUpdate(sql);

            st.close();
            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //ÉSTE MÉTODO FUE GENERADO PARA SER UTILIZADO SÓLO UNA VEZ PARA AGREGAR EMPLEADOS DE EJEMPLO A LA TABLA "EMPLEADOS"
    public void agregarEmpleadosIniciales() {

        try {
            abrirConexion();

            String sql = "INSERT INTO EMPLEADOS (NOMBRE,EDAD,SEXO,LEGAJO,FECHA_ALTA,cant_horas_trabajo) VALUES ('Juan Hernández', 28, 2, 'AAA254', '21/02/2018', 30)";
            st.executeUpdate(sql);

            sql = "INSERT INTO EMPLEADOS (NOMBRE,EDAD,SEXO,LEGAJO,FECHA_ALTA,cant_horas_trabajo) VALUES ('Victoria Luna', 22, 1, 'AAA290', '10/05/2019', 40)";
            st.executeUpdate(sql);

            sql = "INSERT INTO EMPLEADOS (NOMBRE,EDAD,SEXO,LEGAJO,FECHA_ALTA,cant_horas_trabajo) VALUES ('Andrés Diaz', 25, 3, 'AAA991', '21/09/2017', 45)";
            st.executeUpdate(sql);

            st.close();
            conn.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void obtenerEmpleados() {
        Empleado ee = new Empleado();
        try {
            abrirConexion();
            rs = st.executeQuery("SELECT * FROM EMPLEADOS");
            while (rs.next()) {
                System.out.println("Nro. " + rs.getInt("id") + " -> " + rs.getString("nombre") +", Legajo: " +rs.getString("legajo") +
                        ", Edad: " + rs.getInt("edad") + ", Sexo: "+ee.determinarSexoId(rs.getInt("sexo"))+ ", Fecha de alta: " +
                        rs.getString("fecha_alta") + ", Cantidad horas/semana: " + rs.getFloat("cant_horas_trabajo") +
                        ", Sueldo: " + ee.calcularSueldoConParametro(rs.getFloat("cant_horas_trabajo")));
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Empleado> obtenerEmpleadosConArray() {
        ArrayList<Empleado> lista = new ArrayList<Empleado>();
        try {
            abrirConexion();
            ResultSet rs = st.executeQuery("SELECT * FROM EMPLEADOS");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                int sexo = rs.getInt("sexo");
                String legajo = rs.getString("legajo");
                String fecha_alta = rs.getString("fecha_alta");
                float cant_horas_trabajo = rs.getFloat("cant_horas_trabajo");

                Empleado e = new Empleado(id, nombre, edad, sexo, legajo, fecha_alta,cant_horas_trabajo);
                lista.add(e);

            }
            rs.close();
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return lista;
    }

    public void agregarEmpleado(Empleado e) {
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLEADOS (NOMBRE,EDAD,SEXO,LEGAJO,FECHA_ALTA,cant_horas_trabajo ) VALUES (?,?,?,?,?,?)");

            ps.setString(1, e.getNomApellido());
            ps.setInt(2, e.getEdad());
            ps.setInt(3, e.getSexo());
            ps.setString(4, e.getLegajo());
            ps.setString(5, e.getFechaAlta());
            ps.setFloat(6, e.getCantHorasTrabajo());

            ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void modificarEmpleado(Empleado e) {
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("UPDATE EMPLEADOS SET  NOMBRE = ? ,EDAD = ?, SEXO = ?, LEGAJO = ?, FECHA_ALTA = ?, cant_horas_trabajo = ?  WHERE id = ?");
            ps.setString(1, e.getNomApellido());
            ps.setInt(2, e.getEdad());
            ps.setInt(3, e.getSexo());
            ps.setString(4, e.getLegajo());
            ps.setString(5, e.getFechaAlta());
            ps.setFloat(6, e.getCantHorasTrabajo());
            ps.setInt(7, e.getId());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void eliminarEmpleado(int id) {
        try {
            abrirConexion();
            PreparedStatement ps = conn.prepareStatement("DELETE EMPLEADOS WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

}
