package co.com.titamedia.bookshop.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.titamedia.bookshop.api.entity.Cliente;
import co.com.titamedia.bookshop.api.entity.Libro;
import co.com.titamedia.bookshop.api.entity.Prestamo;
import co.com.titamedia.bookshop.api.entity.RequestPrestamo;
import co.com.titamedia.bookshop.api.entity.ResponseAlquiler;
import co.com.titamedia.bookshop.api.entity.ResponseLibro;
import co.com.titamedia.bookshop.api.entity.Usuario;
import co.com.titamedia.bookshop.api.service.IClienteService;
import co.com.titamedia.bookshop.api.service.ILibroService;
import co.com.titamedia.bookshop.api.service.IPrestamoService;
import co.com.titamedia.bookshop.api.service.IUsuarioService;

@RestController
@RequestMapping("/api/libro")
public class LibroController {

	@Autowired
	private ILibroService serviceLibro;

	@Autowired
	private IPrestamoService servicePrestamo;
	
	@Autowired
	private IClienteService  serviceCliente;
	
	@Autowired
	private IUsuarioService serviceUsuario;

	@PostMapping("/crear/{email}")
	public ResponseLibro crear(@RequestBody Libro libro,@PathVariable("email") String email) {
		
		Usuario usuario = serviceUsuario.buscarPorCorreo(email);
		
		ResponseLibro response = new ResponseLibro();
		if (usuario!=null && usuario.getRol().getId_rol()==1) {
		  return serviceLibro.crear(libro);
		}else {
			response.setMessage("Usuario sin permisos para realizar esta acción");
			return  response;
		}

	}

	@DeleteMapping("/eliminar/{id_libro}/{email}")
	public ResponseLibro eliminar(@PathVariable("id_libro") int id,@PathVariable("email") String email) {
		
		Usuario usuario = serviceUsuario.buscarPorCorreo(email);
		ResponseLibro response = new ResponseLibro();
		
		if (usuario!=null && usuario.getRol().getId_rol()==1) {
			  return serviceLibro.eliminar(id);
			}else {
				response.setMessage("Usuario sin permisos para realizar esta acción");
				return  response;
			}
		
	}

	@PutMapping("/modificar/{id}/{email}")
	public ResponseLibro modificar(@RequestBody Libro libro,@PathVariable("id") int id,@PathVariable("email") String email) {
		
		Usuario usuario = serviceUsuario.buscarPorCorreo(email);
		Libro  libroEncontrado = serviceLibro.buscarPorId(id);
		ResponseLibro response = new ResponseLibro();
		
		if (usuario!=null && usuario.getRol().getId_rol()==1) {
			
			if(libroEncontrado!=null) {
				
				 libroEncontrado.setNombre(libro.getNombre());
				 libroEncontrado.setCategoria(libro.getCategoria());
				 libroEncontrado.setCantidad_reservada(libro.getCantidad_reservada());
				 libroEncontrado.setCantidad_disponible(libro.getCantidad_disponible());
				 libroEncontrado.setAutor(libro.getAutor());
				
				 return response= serviceLibro.modificar(libroEncontrado);
			}
			
			response.setMessage("Libro no encontrado");
			return  response;
			
			}else {
				response.setMessage("Usuario sin permisos para realizar esta acción");
				return  response;
			}
		

	}

	@PutMapping("/alquilar")
	public ResponseAlquiler Alquilar(@RequestBody RequestPrestamo reqPrestamo) {
		
		Usuario usuario = serviceUsuario.buscarPorCorreo(reqPrestamo.getCorreo());
		
		Cliente cliente = serviceCliente.buscarPorCorreo(usuario);
		
		ResponseAlquiler response = new ResponseAlquiler();

		
		
		
		int cantidadD=0;
		int cantidads=0;
		boolean isValid=true;
		
		for (int i = 0; i < reqPrestamo.getInformacion().size(); i++) {
			
			cantidadD = serviceLibro.buscarPorId(reqPrestamo.getInformacion().get(i).getId_libro()).getCantidad_disponible();
			cantidads = reqPrestamo.getInformacion().get(i).getCantidad();
			if(!(cantidadD>0)||!(cantidads<=cantidadD)) {
				isValid=false;
				
			}
		}
		
		double tarifaFinal=0;

		if (isValid) {
			response = serviceLibro.Alquilar(reqPrestamo);
			if(response.isStatus()) {
			
			for (int i = 0; i < reqPrestamo.getInformacion().size(); i++) {
				int cantidad = 0;
				int cantidadDisp=0;
				double tarifaPorLibro = 0; 
				double tarifaTotal = 0; 
				Prestamo prestamo = new Prestamo();
				
				cantidadDisp = serviceLibro.buscarPorId(reqPrestamo.getInformacion().get(i).getId_libro()).getCantidad_disponible();
				cantidad = reqPrestamo.getInformacion().get(i).getCantidad();
				
				tarifaPorLibro =  serviceLibro.buscarPorId(reqPrestamo.getInformacion().get(i).getId_libro()).getCategoria().getTarifa();
				
				tarifaTotal = cantidad * tarifaPorLibro;

				prestamo.setFecha_devolucion(reqPrestamo.getFechaDevolucion());
				prestamo.setFecha_prestamo(reqPrestamo.getFechaPrestamo());
				
				prestamo.setCliente(cliente); // enviar un cliente
				prestamo.setLibro(serviceLibro.buscarPorId(reqPrestamo.getInformacion().get(i).getId_libro())); // enviar un libro
				prestamo.setTarifa_total(tarifaTotal);
				

				servicePrestamo.crear(prestamo, cantidad);
				
				tarifaFinal+=tarifaTotal; 
			}

			}
			
			response.setTarifaMostrar(tarifaFinal);
			response.setCodigo(1);
			response.setRespuesta("Prestamo realizado exitosamente");

		} else {
			response.setRespuesta("La cantidad solicitada no esta disponible");
			
			return response;
			
		}
		
		

		return response;
	}

	@GetMapping("/listar")
	public List<Libro> listar() {

		return serviceLibro.Listar();
	}

}
