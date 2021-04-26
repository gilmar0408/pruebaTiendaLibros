package co.com.titamedia.bookshop.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.titamedia.bookshop.api.entity.DetalleLibrosAlquilados;
import co.com.titamedia.bookshop.api.entity.Prestamo;
import co.com.titamedia.bookshop.api.entity.ResponseAlquiler;
import co.com.titamedia.bookshop.api.repository.PrestamoRepository;
import co.com.titamedia.bookshop.api.service.IPrestamoService;

@Service
public class PrestamoService implements IPrestamoService{
	
	@Autowired
	PrestamoRepository repoPrestamo;

	public PrestamoService() {
		
	}
	
	public PrestamoService(PrestamoRepository repoPrestamo) {
		this.repoPrestamo=repoPrestamo;
	}
	
	

	@Override
	public DetalleLibrosAlquilados crear(Prestamo prestamo,int cantidad) {
		
		DetalleLibrosAlquilados  detalle = new DetalleLibrosAlquilados();
		
		detalle.setLibro(prestamo.getLibro().getNombre());
		detalle.setCantidad(cantidad);
		detalle.setPrecio(prestamo.getTarifa_total());
		
		repoPrestamo.save(prestamo);
		
		return detalle;
	}

	@Override
	public List<Prestamo> list() {
		
		return null;
	}

}
