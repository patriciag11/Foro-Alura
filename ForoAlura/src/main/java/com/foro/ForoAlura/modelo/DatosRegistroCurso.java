package com.foro.ForoAlura.modelo;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(
        @NotBlank
        String nombre_curso,

        @NotBlank
        String categoria) {
}
