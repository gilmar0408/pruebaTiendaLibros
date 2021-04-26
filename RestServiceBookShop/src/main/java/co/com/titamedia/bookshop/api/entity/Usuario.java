package co.com.titamedia.bookshop.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	
	@Id
	private String correo_electronico;
	
	private String contrasena;
	private String contrasena_encriptada;
	
	@OneToOne
	@JoinColumn(name="rol")
	private Rol rol;
	
	
	public Usuario() {
		
	}


	public String getCorreo_electronico() {
		return correo_electronico;
	}


	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public String getContrasena_encriptada() {
		return contrasena_encriptada;
	}


	public void setContrasena_encriptada(String contrasena_encriptada) {
		this.contrasena_encriptada = contrasena_encriptada;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
	

}
