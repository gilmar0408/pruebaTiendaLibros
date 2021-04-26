package co.com.titamedia.bookshop.api.service.jpa;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import co.com.titamedia.bookshop.api.entity.Libro;
import co.com.titamedia.bookshop.api.entity.RequestPrestamo;
import co.com.titamedia.bookshop.api.entity.ResponseAlquiler;
import co.com.titamedia.bookshop.api.entity.ResponseLibro;
import co.com.titamedia.bookshop.api.repository.LibroRepository;
import co.com.titamedia.bookshop.api.service.ILibroService;


@Service
public class LibroService implements ILibroService  {
	
	
	
	@Autowired
	private LibroRepository repoLibro;
	
	
	
	public LibroService(){
		
	}
	
    public LibroService(LibroRepository repoLibro){
		this.repoLibro = repoLibro;
	}
	
    
    
	

	@Override
	public ResponseLibro crear(Libro libro) {
		
		//pendiente hacer validaciones de campos
		// pendiente validar existencia de libro
		
		ResponseLibro response = new ResponseLibro();
		repoLibro.save(libro);
		response.setMessage("Libro creado exitosamente");
		response.setLibro(libro);
		
		return response;
	}

	@Override
	public ResponseLibro eliminar(int id) {
		
		//pendiente hacer validaciones de campos
		// pendiente validar existencia de libro
		
		Libro libro = repoLibro.findById(id).get();
		
		ResponseLibro response = new ResponseLibro();
		repoLibro.delete(libro);
		response.setMessage("Libro eliminado exitosamente");
		response.setLibro(libro);
		
		
		return response;
	}

	@Override
	public ResponseLibro modificar(Libro libro) {
		
		
		
		
		
		ResponseLibro response = new ResponseLibro();
		repoLibro.save(libro);
		response.setMessage("Libro actualizado exitosamente");
		response.setLibro(libro);
		
		
		return response;
		
		
	}

	@Override
	public ResponseAlquiler Alquilar(RequestPrestamo reqPrestamo) {
		
		
		ResponseAlquiler response = new ResponseAlquiler();
		
		if(reqPrestamo.validarCampos()) {
			
			System.out.println("tamaño array: "+reqPrestamo.getInformacion().size());
			
			for (int i=0 ; i< reqPrestamo.getInformacion().size() ; i++) {
				
				
				int cantidadDisponible=0;
				int cantidadSolicitada=0;
				int cantidadPrestada=0;
				int nuevaCantidadDis = 0;
				int nuevaCantidadPres = 0;
				Libro libroActualizado ;
				
				Libro encontrado = repoLibro.findById(reqPrestamo.getInformacion().get(i).getId_libro()).get();
				cantidadDisponible = encontrado.getCantidad_disponible();
				System.out.println("Cantidad disponible: "+cantidadDisponible);
				cantidadPrestada = encontrado.getCantidad_reservada();
				System.out.println("Cantidad prestada: "+cantidadPrestada);
				cantidadSolicitada = reqPrestamo.getInformacion().get(i).getCantidad();
				System.out.println("Cantidad Solicitada: "+cantidadSolicitada);
				nuevaCantidadDis= cantidadDisponible - cantidadSolicitada;
				System.out.println("Nueva cantidad disponible: "+nuevaCantidadDis);
				nuevaCantidadPres = cantidadPrestada + cantidadSolicitada;
				System.out.println("Nueva cantidad pestada: "+nuevaCantidadPres);
				libroActualizado= encontrado;
				libroActualizado.setCantidad_disponible(nuevaCantidadDis);
				libroActualizado.setCantidad_reservada(nuevaCantidadPres);
				repoLibro.save(libroActualizado);
				
				response.setRespuesta("Alquiler realizado con exito!");
				response.setStatus(true);
			}
			
			
		}else {
			
			response.setRespuesta("Los datos ingresados son erroneos por favor validar los campos.");
			response.setStatus(false);
		}
		
		
		return response;
		
	}

	@Override
	public List<Libro> Listar() {
	
		
		List<Libro> listaLibros = repoLibro.findAll();
		
		return listaLibros;
		
	}

	@Override
	public Libro buscarPorId(int id) {
		Libro  libro = repoLibro.findById(id).get();
		
		return libro;
	}
	

}
