package cartelera;

public class Pelicula {

    private int id;
    private String nombre;
    private String fechaEstreno;
    private float  duracion;

    //CONTRUCTOR CON PARÁMETROS SIN ID
    public Pelicula(String nombre, String fechaEstreno, float duracion) {
        this.nombre = nombre;
        this.fechaEstreno = fechaEstreno;
        this.duracion = duracion;
    }

    //CONTRUCTOR CON ID Y PARÁMETROS
    public Pelicula(int id, String nombre, String fechaEstreno, float duracion) {
        this.id=id;
        this.nombre = nombre;
        this.fechaEstreno = fechaEstreno;
        this.duracion = duracion;
    }

    //CONTRUCTOR SIN PARÁMETROS
    public Pelicula() {}

    //GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }
    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public float getDuracion() {
        return duracion;
    }
    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public int getId() {return id; }
    public void setId(int id) { this.id = id; }

    //POLIMORFISMO (SOBREESCRITURA DEL MÉTODO toString DE LA CLASE OBJECT)
    @Override
    public String toString() {
        return "Pelicula -> " +
                "Nro. " + id +
                ", Nombre: " + nombre +
                ", Fecha de estreno: " + fechaEstreno +
                ", Duración: " + duracion + "\n";
    }
}
