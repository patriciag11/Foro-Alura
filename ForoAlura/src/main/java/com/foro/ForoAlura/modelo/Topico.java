package com.foro.ForoAlura.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_creacion = LocalDateTime.now();
    @Enumerated (EnumType.STRING)
    private StatusTopico estatus = StatusTopico.NO_RESPONDIDO;

    private boolean activo;
    @Embedded
    private Usuario autor;
    @Embedded
    private Curso curso;
  //  private List<Respuesta> respuestas = new ArrayList<>();

    public Topico(String titulo, String mensaje, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.curso = curso;
    }


    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.activo=true;
        this.titulo= datosRegistroTopico.titulo();
        this.mensaje= datosRegistroTopico.mensaje();
        this.estatus= StatusTopico.valueOf(datosRegistroTopico.estatus());
        this.autor=new Usuario(datosRegistroTopico.usuario());
        this.curso=new Curso(datosRegistroTopico.curso());
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo()!=null){
        this.titulo= datosActualizarTopico.titulo();}

        if (datosActualizarTopico.mensaje()!=null){
        this.mensaje= datosActualizarTopico.mensaje();}
    }

    public void desactivarTopico() {
     this.activo=false;
    }
}