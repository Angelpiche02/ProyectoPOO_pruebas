package modelo;

public class Recordatorio extends Elemento
{
    private String fecha;

    public Recordatorio() {}

    public Recordatorio(int id, String titulo, TipoElemento tipo, String descripcion, String nivelPrioridad, String fecha)
    {
        super(id, titulo, tipo, descripcion, nivelPrioridad);
        this.fecha = fecha;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}