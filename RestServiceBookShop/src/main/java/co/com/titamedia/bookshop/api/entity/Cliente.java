package co.com.titamedia.bookshop.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="cliente")
public class Cliente  implements Serializable {
	
	@Id
	private long cedula;
	
	@OneToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String direccion;
	private int edad;
	
	public Cliente () {
		
	}
	
	public Cliente (long cedula,Usuario usuario,String nombre ,String apellidos,String telefono,String direccion,int edad) {
		
		this.cedula = cedula;
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.edad = edad;
		
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public Usuario getCorreo_electronico() {
		return usuario;
	}

	public void setCorreo_electronico(Usuario correo_electronico) {
		this.usuario = correo_electronico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	
	
	

}
