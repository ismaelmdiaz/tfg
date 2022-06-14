package com.dichotomy.back.security.controller;

import com.dichotomy.back.entity.Producto;
import com.dichotomy.back.security.dto.JwtDto;
import com.dichotomy.back.security.dto.LoginUsuarioDto;
import com.dichotomy.back.security.dto.NuevoUsuarioDto;
import com.dichotomy.back.security.entity.Rol;
import com.dichotomy.back.security.entity.Usuario;
import com.dichotomy.back.security.entity.UsuarioPrincipal;
import com.dichotomy.back.security.enums.RolNombre;
import com.dichotomy.back.security.jwt.JwtProvider;
import com.dichotomy.back.dto.MensajeDto;
import com.dichotomy.back.security.service.RolService;
import com.dichotomy.back.security.service.UsuarioService;
import com.dichotomy.back.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    ProductoService productoService;

    //se devuelve un objeto de tipo genérico
    @PostMapping("/nuevo")//se usa un RequestBody cuando se espera un json
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuarioDto nuevoUsuario, BindingResult bindingResult){//?:tipo genérico

        if(bindingResult.hasErrors())
            return new ResponseEntity(new MensajeDto("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new MensajeDto("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new MensajeDto("ese email ya existe"), HttpStatus.BAD_REQUEST);

        Usuario usuario = new Usuario(nuevoUsuario.getNombre(),
                                      nuevoUsuario.getNombreUsuario(),
                                      nuevoUsuario.getEmail(),
                                      passwordEncoder.encode(nuevoUsuario.getPassword()));

        //relleno cesta
//        Set<Producto> cesta = new HashSet<>();
//        for (String producto : nuevoUsuario.getCesta()) {
//            cesta.add(productoService.getByModel(producto).get());
//        }
//        usuario.setCesta(cesta);

        usuarioService.guardarUsuario(usuario);

        return new ResponseEntity(new MensajeDto("usuario guardado"), HttpStatus.CREATED);
    }

    //se devuelve un objeto de tipo Jwt
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuarioDto loginUsuario, BindingResult bindingResult){

        if(bindingResult.hasErrors())
            return new ResponseEntity(new MensajeDto("campos mal puestos"), HttpStatus.BAD_REQUEST);

        Authentication authentication = authenticationManager.authenticate
                                            (new UsernamePasswordAuthenticationToken
                                            (loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Integer id, @RequestBody NuevoUsuarioDto nuevoUsuarioDto){

        Usuario usuario = usuarioService.getById(id).get();

        usuario.setNombre(nuevoUsuarioDto.getNombre());
        usuario.setEmail(nuevoUsuarioDto.getEmail());

        //relleno roles
//        Set<Rol> roles = new HashSet<>();
//        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

//        if(nuevoUsuarioDto.getRoles().contains("admin")) {
//            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
//        }
//        usuario.setRoles(roles);

        //relleno cesta
        Set<Producto> cesta = new HashSet<>();
        for (Producto producto : nuevoUsuarioDto.getCesta()) {
            cesta.add(producto);
        }
//        Set<Producto> cesta = new HashSet<>();
//        for (String producto : nuevoUsuarioDto.getCesta()) {
//            cesta.add(productoService.getByModel(producto).get());
//        }
        usuario.setCesta(cesta);

        usuarioService.save(usuario);

        return new ResponseEntity(new MensajeDto("usuario actualizado"), HttpStatus.OK);
    }

    //se devuelve un objeto de tipo Usuario
    @PostMapping("/obtencionusuario")
    public ResponseEntity<Usuario> obtencionUsuarioLogueado(@RequestBody String nombreUsuario){

        Usuario usuario = new Usuario();

        if(usuarioService.existsByNombreUsuario(nombreUsuario)==true){
            usuario=usuarioService.getByNombreUsuario(nombreUsuario).get();
            return new ResponseEntity(usuario, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
