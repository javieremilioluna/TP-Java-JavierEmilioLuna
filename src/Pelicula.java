public class Pelicula {

    private String nombre;
    private String fecha_estreno;
    private float  duracion;

    //CONTRUCTOR CON PARÁMETROS
    public Pelicula(String nombre, String fecha_estreno, float duracion) {
        this.nombre = nombre;
        this.fecha_estreno = fecha_estreno;
        this.duracion = duracion;
    }

    //CONTRUCTOR SIN PARÁMETROS
    public Pelicula() {
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_estreno() {
        return fecha_estreno;
    }
    public void setFecha_estreno(String fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public float getDuracion() {
        return duracion;
    }
    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    //POLIMORFISMO (SOBREESCRITURA DEL MÉTODO toString DE LA CLASE OBJECT)
    @Override
    public String toString() {
        return "Pelicula -> " +
                "Nombre: " + nombre +
                ", Fecha de estreno: " + fecha_estreno  +
                ", Duración: " + duracion + "\n";
    }
}
