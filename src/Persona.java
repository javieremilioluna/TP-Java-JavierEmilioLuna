
//CLASE PADRE ABSTRACTA - NO PERMITE INSTANCIAS -
public abstract class Persona {

    protected String nom_apellido;
    protected int edad;
    protected int sexo;

    //CONTRUCTOR CON PARÁMETROS
    public Persona(String nom_apellido, int edad, int sexo) {
        this.nom_apellido = nom_apellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    //MÉTODO ABSTRACTO
    public abstract double calcularSueldo();

    public String getNom_apellido() {
        return nom_apellido;
    }
    public void setNom_apellido(String nom_apellido) {
        this.nom_apellido = nom_apellido;
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

    @Override
    public String toString() {
        return "";
    }
}
