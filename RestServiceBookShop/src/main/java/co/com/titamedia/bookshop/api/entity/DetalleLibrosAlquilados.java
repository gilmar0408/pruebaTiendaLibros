package co.com.titamedia.bookshop.api.entity;

public class DetalleLibrosAlquilados {
	
	private String libro;
	private int cantidad;
	private double precio;

	public DetalleLibrosAlquilados() {
		
	}
	
	public DetalleLibrosAlquilados(String libro,int cantidad,double precio) {
		this.libro = libro;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	

}
