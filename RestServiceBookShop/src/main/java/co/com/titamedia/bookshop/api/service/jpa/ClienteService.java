package co.com.titamedia.bookshop.api.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.titamedia.bookshop.api.entity.Cliente;
import co.com.titamedia.bookshop.api.entity.Usuario;
import co.com.titamedia.bookshop.api.repository.ClienteRepository;
import co.com.titamedia.bookshop.api.service.IClienteService;

@Service
public class ClienteService  implements IClienteService {
	
	@Autowired
	private ClienteRepository repoCliente;

	

	@Override
	public String registrar(Cliente cliente) {
		String respuesta="Cliente no registrado";
		
		Cliente registrado = repoCliente.save(cliente);
		
		if(registrado!=null) {
			
			respuesta = "Cliente registrado con exito!";
			
		}
		
		return respuesta;
	}



	@Override
	public Cliente buscarPorCorreo(Usuario usuario) {
		
		Cliente response = repoCliente.buscarPorCorreo(usuario);
		
		return response;
	}
	

}
