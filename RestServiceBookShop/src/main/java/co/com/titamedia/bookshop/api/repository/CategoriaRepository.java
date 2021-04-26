package co.com.titamedia.bookshop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.titamedia.bookshop.api.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
