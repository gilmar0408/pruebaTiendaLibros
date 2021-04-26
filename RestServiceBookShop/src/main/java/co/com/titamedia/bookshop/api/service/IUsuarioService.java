package co.com.titamedia.bookshop.api.service;

import co.com.titamedia.bookshop.api.entity.Usuario;

public interface IUsuarioService {
	
	Usuario  crear(Usuario usuario);
	Usuario  buscarPorCorreo(String correo);

}
