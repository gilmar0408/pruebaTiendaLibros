package co.com.titamedia.bookshop.api.service.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.titamedia.bookshop.api.entity.Categoria;
import co.com.titamedia.bookshop.api.repository.CategoriaRepository;
import co.com.titamedia.bookshop.api.service.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService{
	
	@Autowired
	private CategoriaRepository repoCategoria;

	@Override
	public String crear(Categoria categoria) {
		String respuesta = "Categoria no registrada";
		
		Categoria registrada = repoCategoria.save(categoria);
		
		if (registrada!=null) {
			respuesta = "Categoria registrada exitosamente!";
		}
		
		return respuesta;
	}

	@Override
	public String actualizar(int id,double tarifa) {
		
		String respuesta = "Categoria no existe";
		
		Categoria categoria = buscarPorId(id);
		
		if(categoria!=null) {
			
			categoria.setTarifa(tarifa);
			
			repoCategoria.save(categoria);
			
			respuesta = "Tarifa actualizada exitosamente!";
			
		}
		
		return respuesta;
	}
	

	@Override
	public Categoria buscarPorId(int id) {
		
		Optional <Categoria> encontrada = repoCategoria.findById(id);
		
		if(encontrada.isPresent()) {
			
			return encontrada.get();
			
		}
		
		return null;
	}

	
	
	

}
