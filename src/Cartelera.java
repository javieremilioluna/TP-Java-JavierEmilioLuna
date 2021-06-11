import java.util.ArrayList;

public class Cartelera {

    //COMPOSICIÓN - CARTELERA "TIENE" PELÍCULA/S
    private ArrayList<Pelicula> peliculas;

    //CONSTRUCTOR
    public Cartelera()
    {
        peliculas = new ArrayList();
    }

    //MÉTODO QUE DEVUELVE LA LISTA DE PELÍCULAS
    public ArrayList<Pelicula> getPeliculas()
    { return peliculas; }

    //MÉTODO QUE PERMITE AGREGAR NUEVAS PELÍCULAS AL ARRAYLIST
    public void agregarPelicula(Pelicula p)
    { peliculas.add(p); }

    //MÉTODO QUE CALCULA LA CANTIDAD DE PELÍCULAS CON UNA DURACIÓN MAYOR A 2 HORAS
    public int cantPeliculasConDuracionMayorA2Horas()
    {
        int contador=0;

        for (Pelicula pelicula: peliculas) {
            if (pelicula.getDuracion() > 2)
            {
                contador++;
            }
        }
        return contador;
    }

    //MÉTODO QUE MUESTRA LA PELÍCULA DE MENOR DURACIÓN
    public Pelicula peliculaMasCorta() {

        Pelicula auxiliar = peliculas.get(0);
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i) != null && peliculas.get(i).getDuracion() < auxiliar.getDuracion()){
                auxiliar = peliculas.get(i);
            }
        }
        return auxiliar;
    }
}
