package co.com.titamedia.bookshop.api.entity;

import java.util.ArrayList;

public class ResponseAlquiler {
	
	private int codigo;
	private boolean status;
	private String respuesta;
	private double tarifaMostrar;
	private ArrayList<DetalleLibrosAlquilados> detalleLibros;

	public ResponseAlquiler() {
		
	}
	
	public ResponseAlquiler(int codigo,boolean status,String respuesta,double tarifaTotal , ArrayList<DetalleLibrosAlquilados> detalleLibros) {
		
		this.codigo = codigo;
		this.respuesta = respuesta;
		this.tarifaMostrar = tarifaTotal;
		this.detalleLibros = detalleLibros;
		this.status = status;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public double getTarifaMostrar() {
		return tarifaMostrar;
	}

	public void setTarifaMostrar(double tarifaTotal) {
		this.tarifaMostrar = tarifaTotal;
	}

	public ArrayList<DetalleLibrosAlquilados> getDetalleLibros() {
		return detalleLibros;
	}

	public void setDetalleLibros(ArrayList<DetalleLibrosAlquilados> detalleLibros) {
		this.detalleLibros = detalleLibros;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
