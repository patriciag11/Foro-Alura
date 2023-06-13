package com.foro.ForoAlura.controller;

import com.foro.ForoAlura.modelo.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topico")
public class ForoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity <DatosListadoTopico> registrarForo (@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
      Topico topico= topicoRepository.save(new Topico(datosRegistroTopico));
      DatosListadoTopico datosListadoTopico= new DatosListadoTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), String.valueOf(topico.getFecha_creacion()),
              topico.getEstatus().toString(), topico.getAutor().getNombre_autor(),topico.getCurso().getNombre_curso());

        URI uri = uriComponentsBuilder.path ("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(datosListadoTopico);
    }


    @GetMapping
    public ResponseEntity <Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(sort = "titulo") Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity ActualizarTopico (@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico= topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos (datosActualizarTopico);
        return ResponseEntity.ok(new NuevoListadoTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),
                String.valueOf(topico.getFecha_creacion()),topico.getEstatus().toString(), topico.getAutor().getNombre_autor(),topico.getAutor().getEmail(),
                topico.getAutor().getContrasena(),topico.getCurso().getNombre_curso(),topico.getCurso().getCategoria()));
    }

    //delete lógico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico= topicoRepository.getReferenceById(id);
        topico.desactivarTopico ();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity TopicoId(@PathVariable Long id){
        Topico topico= topicoRepository.getReferenceById(id);
        var Datostopico= new NuevoListadoTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),
                String.valueOf(topico.getFecha_creacion()),topico.getEstatus().toString(), topico.getAutor().getNombre_autor(),topico.getAutor().getEmail(),
                topico.getAutor().getContrasena(),topico.getCurso().getNombre_curso(),topico.getCurso().getCategoria());

        return ResponseEntity.ok(Datostopico);
    }
}
