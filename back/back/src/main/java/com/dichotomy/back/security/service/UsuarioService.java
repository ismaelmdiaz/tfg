package com.dichotomy.back.security.service;

import com.dichotomy.back.entity.Producto;
import com.dichotomy.back.security.dto.LoginUsuarioDto;
import com.dichotomy.back.security.entity.Rol;
import com.dichotomy.back.security.entity.Usuario;
import com.dichotomy.back.security.enums.RolNombre;
import com.dichotomy.back.security.repository.UsuarioRepository;
import com.dichotomy.back.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolService rolService;

    @Autowired
    ProductoService productoService;

    @Autowired
    UsuarioService usuarioService;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public Optional<Usuario> getById(int id){
        return usuarioRepository.findById(id);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByPassword(String password){
        return usuarioRepository.existsByPassword(password);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void guardarUsuario(Usuario usuario){

        //relleno roles
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

        if(usuario.getRoles().contains("admin")) {
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        usuario.setRoles(roles);

        usuarioService.save(usuario);
    }

    public void eliminarElemento(Usuario usuario, int indice){

        usuario.getCesta().remove(indice);
    }
}
