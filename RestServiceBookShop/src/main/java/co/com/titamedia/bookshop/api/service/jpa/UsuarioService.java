package co.com.titamedia.bookshop.api.service.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.titamedia.bookshop.api.entity.Usuario;
import co.com.titamedia.bookshop.api.repository.UsuarioRepository;
import co.com.titamedia.bookshop.api.service.IUsuarioService;

@Service
public class UsuarioService  implements IUsuarioService {
	
	@Autowired
	private  UsuarioRepository  repoUsuario;

	@Override
	public Usuario crear(Usuario usuario) {
		
		return repoUsuario.save(usuario);
		
	}

	@Override
	public Usuario buscarPorCorreo(String correo) {
		
		
		Optional <Usuario> encontrado = repoUsuario.findById(correo);
		
		if(encontrado.isPresent()) {
			
			return encontrado.get();
			
		}
		
		return null;
	}

	

	
}
