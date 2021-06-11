

public class Empleado extends Persona{ //RELACIÓN DE HERENCIA - EMPLEADO "ES UNA" PERSONA

    private String legajo;
    private String fecha_alta;
    private float cant_horas_trabajo;

    //CONTRUCTOR CON PARÁMETROS HEREDANDO LOS ATRIBUTOS DE PERSONA
    public Empleado(String nom_apellido, int edad, int sexo, String legajo, String fecha_alta, float cant_horas_trabajo) {
        super(nom_apellido, edad, sexo);
        this.legajo = legajo;
        this.fecha_alta = fecha_alta;
        this.cant_horas_trabajo=cant_horas_trabajo;
    }

    public String getLegajo() { return legajo; }
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getFecha_alta() { return fecha_alta; }
    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public float getCant_horas_trabajo() { return cant_horas_trabajo; }
    public void setCant_horas_trabajo(float cant_horas_trabajo) { this.cant_horas_trabajo = cant_horas_trabajo; }

    //MÉTODO QUE SOBREESCRIBE AL MÉTODO ABSTRACTO "calcularSueldo()" DE LA CLASE PADRE
    @Override
    public double calcularSueldo() {
        return cant_horas_trabajo*600;
    }

    //MÉTODO ESTÁTICO QUE MUESTRA AYUDA SOBRE LA CARGA DE EMPLEADOS, SE PUEDE USAR SIN INSTANCIAR LA CLASE
    public static String mostrarAyudaSobreAltas()
    {
        return "HELP\nPASOS PARA DAR DE ALTA UN EMPLEADO:\n1- Ingrese nombre y apellido completos del empleado a cargar.\n" +
                "2- Consulte con el área de RRHH el número de legajo asignado.\n" +
                "3- Ingrese la fecha de alta (firma de contrato).\n" +
                "4- Ingrese edad de empleado.\n" +
                "5- Ingrese código de sexo de empleado (1:Mujer, 2: Hombre, 3:Otro)\n"+
                "6- Ingrese la cantidad que horas semanales que trabaja el empleado.\n" ;
    }

    //MÉTODO QUE DETERMINA EL SEXO DEL EMPLEADO USANDO SWITCH
    public String determinarSexo()
    {
        String sexoString="";
        switch (this.sexo)
        {
            case 1 : sexoString = "Mujer"; break;
            case 2 : sexoString = "Hombre";break;
            case 3 : sexoString = "Otro";break;
            default: sexoString ="Otros"; break;
        }
        return sexoString;
    }


    @Override
    public String toString() {

        return "Empleado -> " +
                "Nombre y apellido: " + nom_apellido +
                ", Legajo: " + legajo  +
                ", Fecha Alta: " + fecha_alta +
                ", Edad: " + edad +
                ", Sexo: " + determinarSexo()+
                ", Cantidad de horas/semana: " + cant_horas_trabajo;
    }
}
