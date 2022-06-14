package com.dichotomy.back.security.repository;

import com.dichotomy.back.security.dto.LoginUsuarioDto;
import com.dichotomy.back.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByPassword(String password);

    boolean existsByEmail(String email);



}
