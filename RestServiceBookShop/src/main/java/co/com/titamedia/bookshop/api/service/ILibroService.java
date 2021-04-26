package co.com.titamedia.bookshop.api.service;

import java.util.List;

import co.com.titamedia.bookshop.api.entity.Libro;
import co.com.titamedia.bookshop.api.entity.RequestPrestamo;
import co.com.titamedia.bookshop.api.entity.ResponseAlquiler;
import co.com.titamedia.bookshop.api.entity.ResponseLibro;

public interface ILibroService {
	
	ResponseLibro     crear (Libro libro);
	ResponseLibro     eliminar (int id);
	ResponseLibro     modificar (Libro libro);
	ResponseAlquiler  Alquilar (RequestPrestamo reqPrestamo);
	List<Libro>       Listar ();
	Libro             buscarPorId(int id);
	

}
