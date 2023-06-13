package com.foro.ForoAlura.modelo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {


    private String nombre_autor;
    private String email;
    private String contrasena;


    public Usuario(DatosRegistroUsuario usuario) {
        this.nombre_autor= usuario.nombre_autor();
        this.email=usuario.email();
        this.contrasena=usuario.contrasena();
    }



}
