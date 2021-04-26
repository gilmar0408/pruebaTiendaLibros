package co.com.titamedia.bookshop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.titamedia.bookshop.api.entity.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, String> {
	
	

}
