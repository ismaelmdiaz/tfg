package com.dichotomy.back.repository;

import com.dichotomy.back.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Optional<Producto> findByModel(String model);
    List<Producto> findByBrand(String marca);
//    boolean existsByNombre(String nombre);
}
