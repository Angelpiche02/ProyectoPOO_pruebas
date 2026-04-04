package modelo;

public class SubTarea
{
    private String titulo;
    private boolean completada;

    public SubTarea(String titulo)
    {
        this.titulo = titulo;
        this.completada = false;
    }

    public String getTitulo(){return titulo;}
    public boolean isCompletada(){return completada;}

    public void completar(){
        this.completada = true;
    }
}