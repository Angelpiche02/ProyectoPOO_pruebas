package modelo;
import java.util.ArrayList;
import java.util.List;

public class Tarea extends Elemento
{
    private String estado;
    private String categoria;

    private boolean esRepetitiva;
    private Frecuencia frecuencia;

    private List<SubTarea> subtareas;

    public enum Frecuencia
    {
        DIARIA, SEMANAL, MENSUAL
    }

    public Tarea() {
        this.subtareas = new ArrayList<>();
    }

    public Tarea(int id, String titulo, TipoElemento tipo, String descripcion, String nivelPrioridad, String estado, String categoria)
    {
        super(id, titulo, tipo, descripcion, nivelPrioridad);
        this.estado = estado;
        this.categoria = categoria;
        this.esRepetitiva = false;
        this.frecuencia = null;
        this.subtareas = new ArrayList<>();
    }

    public String getEstado(){return this.estado;}
    public String getCategoria(){return this.categoria;}
    public boolean esRepetitiva(){return this.esRepetitiva;}
    public Frecuencia getFrecuencia(){return this.frecuencia;}
    public List<SubTarea> getSubtareas(){return this.subtareas;}

    public void setEstado(String estado){this.estado = estado;}
    public void setCategoria(String categoria){this.categoria = categoria;}
    public void setEsRepetitiva(boolean esRepetitiva){this.esRepetitiva = esRepetitiva;}
    public void setFrecuencia(Frecuencia frecuencia){this.frecuencia = frecuencia;}

    public void agregarSubTarea(String titulo){
        subtareas.add(new SubTarea(titulo));
        actualizarEstado();
    }

    public void completarSubTarea(int i){
        if (i >= 0 && i < subtareas.size()){
            subtareas.get(i).completar();
            actualizarEstado();
        }
    }

    public int calcularProgreso(){
        if (subtareas.isEmpty()) return 0;

        int completadas = 0;

        for (SubTarea s : subtareas){
            if (s.isCompletada()){
                completadas++;
            }
        }

        return (completadas * 100) / subtareas.size();
    }

    public void actualizarEstado(){
        int progreso = calcularProgreso();

        if (progreso == 100){
            this.estado = "Completada";
        } else if (progreso > 0){
            this.estado = "En progreso";
        } else {
            this.estado = "Pendiente";
        }
    }

    public static List<Elemento> obtenerTareas()
    {
        List<Elemento> tareas = new ArrayList<>();

        for (Elemento e : Elemento.elementos)
        {
            if (e.getTipo() == TipoElemento.TAREA)
            {
                tareas.add(e);
            }
        }

        return tareas;
    }

    public static void mostrarTareas()
    {
        List<Elemento> tareas = obtenerTareas();

        System.out.println("\n--- LISTA DE TAREAS ---");

        for (Elemento e : tareas)
        {
            e.mostrarElemento();

            if (e instanceof Tarea)
            {
                Tarea t = (Tarea) e;
                System.out.println("Estado: " + t.getEstado());
                System.out.println("Categoría: " + t.getCategoria());
                System.out.println("Progreso: " + t.calcularProgreso() + "%");

                if (t.esRepetitiva())
                {
                    System.out.println("Repetitiva: Sí (" + t.getFrecuencia() + ")");
                }
                else
                {
                    System.out.println("Repetitiva: No");
                }

                if (!t.getSubtareas().isEmpty())
                {
                    System.out.println("Subtareas:");
                    for (SubTarea s : t.getSubtareas())
                    {
                        System.out.println(" - " + (s.isCompletada() ? "[X] " : "[ ] ") + s.getTitulo());
                    }
                }
            }

            System.out.println("---------------------");
        }
    }
}