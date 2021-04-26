package co.com.titamedia.bookshop.api.service;

import co.com.titamedia.bookshop.api.entity.Cliente;
import co.com.titamedia.bookshop.api.entity.Usuario;

public interface IClienteService {
	
	String registrar(Cliente cliente);
	Cliente  buscarPorCorreo(Usuario usuario);

}
