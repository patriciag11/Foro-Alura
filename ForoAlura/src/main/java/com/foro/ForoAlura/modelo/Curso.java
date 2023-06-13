package com.foro.ForoAlura.modelo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {


    private String nombre_curso;
    private String categoria;

    public Curso(DatosRegistroCurso curso) {
        this.nombre_curso= curso.nombre_curso();
        this.categoria= curso.categoria();
    }
}