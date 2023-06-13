package com.foro.ForoAlura.modelo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotNull
        String estatus,

        @NotNull
        @Valid
        DatosRegistroUsuario usuario,

        @NotNull
        @Valid
        DatosRegistroCurso curso) {
}
