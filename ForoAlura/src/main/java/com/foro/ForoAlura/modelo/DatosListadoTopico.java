package com.foro.ForoAlura.modelo;

import java.time.LocalDate;
import java.util.Date;

public record DatosListadoTopico(Long id,String titulo, String mensaje, String fecha_creacion, String estatus, String autor, String curso) {

    public DatosListadoTopico (Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), String.valueOf(topico.getFecha_creacion()),
                topico.getEstatus().toString(), topico.getAutor().getNombre_autor(),topico.getCurso().getNombre_curso());
    }

}
