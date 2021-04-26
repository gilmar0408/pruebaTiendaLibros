package co.com.titamedia.bookshop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.titamedia.bookshop.api.entity.Cliente;
import co.com.titamedia.bookshop.api.entity.Usuario;


public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
	
	
	@Query("SELECT new co.com.titamedia.bookshop.api.entity.Cliente(c.cedula,c.usuario,c.nombre,c.apellidos,c.telefono,"
			+ "c.direccion,c.edad) FROM Cliente c WHERE c.usuario = ?1")
	public Cliente buscarPorCorreo(Usuario usuario);

}
