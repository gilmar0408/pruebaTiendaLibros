package co.com.titamedia.bookshop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.titamedia.bookshop.api.entity.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

}
