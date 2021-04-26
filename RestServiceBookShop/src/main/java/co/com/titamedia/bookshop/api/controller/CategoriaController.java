package co.com.titamedia.bookshop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.titamedia.bookshop.api.entity.Categoria;
import co.com.titamedia.bookshop.api.entity.Usuario;
import co.com.titamedia.bookshop.api.service.ICategoriaService;
import co.com.titamedia.bookshop.api.service.IUsuarioService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private ICategoriaService serviceCategoria;
	
	@Autowired
	private IUsuarioService   serviceUsuario;
	
	@PostMapping("/crear")
	public String crear(@RequestBody Categoria categoria) {
		
		return serviceCategoria.crear(categoria);
		
	}
	
	
	@PutMapping("/actualizar/{id}/{email}/{tarifa}")
	public String actualizar(@PathVariable("id") int id ,@PathVariable("email") String email,@PathVariable("tarifa") double tarifa) {
		
		Usuario usuario = serviceUsuario.buscarPorCorreo(email);
		
		if(usuario!=null && usuario.getRol().getId_rol()==1) {
		
		return serviceCategoria.actualizar(id, tarifa);
		
		}
		
		return "El usuario no tiene permisos para realizar esta acción";
		
	}

}
