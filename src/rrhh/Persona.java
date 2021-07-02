package rrhh;

//CLASE PADRE ABSTRACTA - NO PERMITE INSTANCIAS -
public abstract class Persona {

    protected int id;
    protected String nomApellido;
    protected int edad;
    protected int sexo;

    //CONTRUCTOR CON PARÁMETROS
    public Persona(int id, String nomApellido, int edad, int sexo) {
        this.id= id;
        this.nomApellido = nomApellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    //CONTRUCTOR CON PARÁMETROS SIN ID
    public Persona(String nomApellido, int edad, int sexo) {
        this.nomApellido = nomApellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    //CONSTRUCTOR SIN PARÁMETROS
    public Persona() {}

    //MÉTODO ABSTRACTO
    public abstract double calcularSueldo();

    //GETTERS & SETTERS
    public String getNomApellido() {
        return nomApellido;
    }
    public void setNomApellido(String nomApellido) {
        this.nomApellido = nomApellido;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSexo() {
        return sexo;
    }
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getId() {return id; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "";
    }
}
