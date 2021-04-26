package co.com.titamedia.bookshop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.titamedia.bookshop.api.entity.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {


	
}
