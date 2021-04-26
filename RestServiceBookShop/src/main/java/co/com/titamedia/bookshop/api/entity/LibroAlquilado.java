package co.com.titamedia.bookshop.api.entity;

public class LibroAlquilado {
	
	private Integer id_libro;
	private Integer cantidad;

	public LibroAlquilado() {
		
	}
	
    public LibroAlquilado(int id_libro ,int cantidad ) {
		
    	this.id_libro = id_libro;
    	this.cantidad = cantidad;
    	
	}
    
    public boolean validarCampos() {
    	
    	boolean esValido=false;
    	
    	if(this.id_libro!=null && this.cantidad != null && this.id_libro>0 && this.cantidad >0 ) {
    		
    		esValido= true;
    	}
    	
    	return esValido;
    }

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

}
