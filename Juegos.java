package prog.ud8.proyecto;

public class Juegos {
	private String titulo;
	private String empresa_creadora;
	private int precio;
	private int fecha_salida;
	private int valoracion;
	
	public Juegos(String titulo, String empresa_creadora, int precio, int fecha_salida, int valoracion) {
		this.titulo = titulo;
		this.empresa_creadora = empresa_creadora;
		this.precio = precio;
		this.fecha_salida = fecha_salida;
		this.valoracion = valoracion;
	}
}
