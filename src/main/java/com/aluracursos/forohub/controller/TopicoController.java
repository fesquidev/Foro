package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.DatosActualizarTopico;
import com.aluracursos.forohub.domain.topico.DatosCrearTopico;
import com.aluracursos.forohub.domain.topico.TopicoResponse;
import com.aluracursos.forohub.model.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponse> obtenerTopico(@PathVariable Long id) {
        TopicoResponse topico = topicoService.obtenerTopico(id);
        if (topico == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<List<TopicoResponse>> listarTopicos() {
        return ResponseEntity.ok(topicoService.listarTopicos());
    }

    @PostMapping
    public ResponseEntity<TopicoResponse> guardarTopico(@RequestBody @Valid DatosCrearTopico datos, UriComponentsBuilder uriBuilder) {
        var response = topicoService.guardarTopico(datos);
        URI url = uriBuilder.path("/topicos/{id}").buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(url).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponse> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {
        TopicoResponse topico = topicoService.obtenerTopico(id);
        if (topico == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(topicoService.actualizarTopico(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
