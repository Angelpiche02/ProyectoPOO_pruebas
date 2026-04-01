package modelo;

public class Elemento
{
    private int id;
    private String titulo;
    public tipoElemento tipo;
    private String descripcion;
    private String nivelPrioridad;

    public static List<Elemento> elementos = new ArrayList<>();

    public Elemento() {}

    public Elemento(int id, String titulo , tipoElemento tipo, String descripcion, String nivelPrioridad)
    {
        this.id = id;
        this.titulo = titulo;
        this.tipoElemento = tipoElemento;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.nivelPrioridad = nivelPrioridad;
    }



}
