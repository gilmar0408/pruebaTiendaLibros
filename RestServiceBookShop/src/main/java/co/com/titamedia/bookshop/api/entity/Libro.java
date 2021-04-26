package co.com.titamedia.bookshop.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_libro;
	
	private String nombre;
	private String autor;
	
	@OneToOne
	@JoinColumn(name="categoria")
	private Categoria categoria;
	
	private int cantidad_disponible;
	private int cantidad_reservada;
	
	
	public Libro () {
		
	}
	
	public Libro (int id_libro,String nombre,String autor,Categoria categoria,int cantidad_disponible,int cantidad_reservada ) {
	
		this.id_libro = id_libro;
		this.nombre = nombre; 	
		this.autor = autor;
		this.categoria= categoria;
		this.cantidad_disponible = cantidad_disponible;
		this.cantidad_reservada = cantidad_reservada;
		
	}
	
	
	
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getCantidad_disponible() {
		return cantidad_disponible;
	}
	public void setCantidad_disponible(int cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}
	public int getCantidad_reservada() {
		return cantidad_reservada;
	}
	public void setCantidad_reservada(int cantidad_reservada) {
		this.cantidad_reservada = cantidad_reservada;
	}
	
	
	

}
