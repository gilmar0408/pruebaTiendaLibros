package co.com.titamedia.bookshop.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="prestamo")
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_prestamo;
	
	@OneToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name="libro")
	private Libro libro;
	
	private Date fecha_prestamo;
	private Date fecha_devolucion;
	
	private double tarifa_total;
	
	public Prestamo() {
		
	}

	public int getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public double getTarifa_total() {
		return tarifa_total;
	}

	public void setTarifa_total(double tarifa_total) {
		this.tarifa_total = tarifa_total;
	}
	
	

	

}
