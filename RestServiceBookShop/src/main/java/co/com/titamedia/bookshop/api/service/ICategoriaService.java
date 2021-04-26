package co.com.titamedia.bookshop.api.service;

import co.com.titamedia.bookshop.api.entity.Categoria;

public interface ICategoriaService {
	
	String crear(Categoria categoria);
	String actualizar(int id,double tarifa);
	Categoria  buscarPorId(int id);

}
