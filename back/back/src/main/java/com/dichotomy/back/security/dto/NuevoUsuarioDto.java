package com.dichotomy.back.security.dto;

import com.dichotomy.back.entity.Producto;
import com.dichotomy.back.security.entity.Rol;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class NuevoUsuarioDto {

    @NotBlank
    private String nombre;

    @NotBlank
    private String nombreUsuario;

    @Email
    private String email;

    @NotBlank
    private String password;

    private Set<Rol> roles = new HashSet<>();

    private Set<Producto> cesta = new HashSet<>();
//    private Set<String> cesta = new HashSet<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Set<Producto> getCesta() {
        return cesta;
    }

    public void setCesta(Set<Producto> cesta) {
        this.cesta = cesta;
    }


//    public Set<String> getCesta() {
//        return cesta;
//    }
//
//    public void setCesta(Set<String> cesta) {
//        this.cesta = cesta;
//    }
}
