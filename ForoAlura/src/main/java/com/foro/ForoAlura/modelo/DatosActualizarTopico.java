package com.foro.ForoAlura.modelo;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id, String titulo, String mensaje) {
}
