package co.com.titamedia.bookshop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.titamedia.bookshop.api.entity.Cliente;
import co.com.titamedia.bookshop.api.service.IClienteService;
import co.com.titamedia.bookshop.api.service.IUsuarioService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private IClienteService serviceCliente;
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@PostMapping("/registrar")
	public String registrarCliente(@RequestBody Cliente cliente) {
		
		serviceUsuario.crear(cliente.getCorreo_electronico());
		return serviceCliente.registrar(cliente);
		
	}
	

}
