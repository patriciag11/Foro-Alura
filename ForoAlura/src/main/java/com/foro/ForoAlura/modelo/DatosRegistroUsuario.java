package com.foro.ForoAlura.modelo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(
        @NotBlank
        String nombre_autor,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String contrasena

) {
}
