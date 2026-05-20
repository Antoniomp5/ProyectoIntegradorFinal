package prog.ud8.proyecto;

public class Juegos {
    private String titulo;
    private String empresa_creadora;
    private int precio;
    private int fecha_salida;
    private int valoracion;

    // Constructor vacío (Obligatorio para serializar XML)
    public Juegos() {}

    // Tu constructor original
    public Juegos(String titulo, String empresa_creadora, int precio, int fecha_salida, int valoracion) {
        this.titulo = titulo;
        this.empresa_creadora = empresa_creadora;
        this.precio = precio;
        this.fecha_salida = fecha_salida;
        this.valoracion = valoracion;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getEmpresa_creadora() { return empresa_creadora; }
    public void setEmpresa_creadora(String empresa_creadora) { this.empresa_creadora = empresa_creadora; }

    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }

    public int getFecha_salida() { return fecha_salida; }
    public void setFecha_salida(int fecha_salida) { this.fecha_salida = fecha_salida; }

    public int getValoracion() { return valoracion; }
    public void setValoracion(int valoracion) { this.valoracion = valoracion; }
}
}
