package co.com.titamedia.bookshop.api.service;

import java.util.List;

import co.com.titamedia.bookshop.api.entity.DetalleLibrosAlquilados;
import co.com.titamedia.bookshop.api.entity.Prestamo;


public interface IPrestamoService {
	
	DetalleLibrosAlquilados crear(Prestamo prestamo,int cantidad);
	List<Prestamo>   list();

}
