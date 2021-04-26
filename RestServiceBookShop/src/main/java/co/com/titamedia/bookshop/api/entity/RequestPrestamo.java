package co.com.titamedia.bookshop.api.entity;

import java.sql.Date;
import java.util.ArrayList;

public class RequestPrestamo {
	
	private String correo;
	private ArrayList<LibroAlquilado> informacion;
	private Date fechaPrestamo;
	private Date fechaDevolucion;

	public RequestPrestamo() {
		
	}
	
	public RequestPrestamo(ArrayList<LibroAlquilado> informacion ,Date fechaPrestamo,Date fechaDevolucion,String correo) {
		
		this.informacion = informacion;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.correo = correo;
	}
	
	public boolean validarCampos() {
		
		boolean esValido=true;
		
		if(this.fechaPrestamo==null || this.fechaDevolucion==null) {
			
			esValido=false;
			
		}else {
			
			for (LibroAlquilado  libro : this.informacion) {
				
				if(!libro.validarCampos()) {
					esValido=false;
				}
			}
		}
		
		return  esValido;
	}
	

	
	
	
	
	public ArrayList<LibroAlquilado> getInformacion() {
		return informacion;
	}

	public void setInformacion(ArrayList<LibroAlquilado> informacion) {
		this.informacion = informacion;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
