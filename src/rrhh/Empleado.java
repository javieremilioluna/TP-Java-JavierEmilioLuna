package rrhh;

public class Empleado extends Persona{ //RELACIÓN DE HERENCIA - EMPLEADO "ES UNA" PERSONA

    private String legajo;
    private String fechaAlta;
    private float cantHorasTrabajo;

    //CONTRUCTOR CON PARÁMETROS HEREDANDO LOS ATRIBUTOS DE PERSONA
    public Empleado(int id, String nomApellido, int edad, int sexo, String legajo, String fechaAlta, float cantHorasTrabajo) {
        super(id,nomApellido, edad, sexo);
        this.legajo = legajo;
        this.fechaAlta = fechaAlta;
        this.cantHorasTrabajo = cantHorasTrabajo;
    }

    //CONTRUCTOR CON PARÁMETROS HEREDANDO LOS ATRIBUTOS DE PERSONA SIN ID
    public Empleado( String nomApellido, int edad, int sexo, String legajo, String fechaAlta, float cantHorasTrabajo) {
        super(nomApellido, edad, sexo);
        this.legajo = legajo;
        this.fechaAlta = fechaAlta;
        this.cantHorasTrabajo = cantHorasTrabajo;
    }

    //CONSTRUCTOR SIN PARÁMETROS
    public Empleado() {
        super();
    }

    //GETTERS & SETTERS
    public String getLegajo() { return legajo; }
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getFechaAlta() { return fechaAlta; }
    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public float getCantHorasTrabajo() { return cantHorasTrabajo; }
    public void setCantHorasTrabajo(float cantHorasTrabajo) { this.cantHorasTrabajo = cantHorasTrabajo; }

    //MÉTODO QUE SOBREESCRIBE AL MÉTODO ABSTRACTO "calcularSueldo()" DE LA CLASE PADRE
    @Override
    public double calcularSueldo() {
        return cantHorasTrabajo *600;
    }

    //MÉTODO QUE CALCULA EL SUELDO DEL EMPLEADO PARA SER UTILIZADO EN CONJUNTO CON EL RESULTADO DE LA CONSULTA SQL
    public double calcularSueldoConParametro(float cantHoras) {
        return cantHoras *600;
    }

    //MÉTODO ESTÁTICO DE EJEMPLO QUE MUESTRA AYUDA SOBRE LA CARGA DE EMPLEADOS, SE PUEDE USAR SIN INSTANCIAR LA CLASE
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

    //MÉTODO CON PARÁMETRO QUE DETERMINA EL SEXO DEL EMPLEADO USANDO SWITCH PARA SER UTILIZADO EN CONJUNTO CON EL RESULTADO DE LA CONSULTA SQL
    public String determinarSexoId(int idSexo)
    {
        String sexoString="";
        switch (idSexo)
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
                "Nro. "+ id +
                ", Nombre y apellido: " + nomApellido +
                ", Legajo: " + legajo  +
                ", Fecha Alta: " + fechaAlta +
                ", Edad: " + edad +
                ", Sexo: " + determinarSexo()+
                ", Cantidad de horas/semana: " + cantHorasTrabajo +
                "\n";
    }
}
