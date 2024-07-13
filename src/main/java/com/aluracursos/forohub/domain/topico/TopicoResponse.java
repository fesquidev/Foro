package com.aluracursos.forohub.domain.topico;

import com.aluracursos.forohub.model.entity.Topico;

import java.time.LocalDateTime;

public record TopicoResponse(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion
) {
    public TopicoResponse(Topico dato) {
        this(dato.getId(), dato.getTitulo(), dato.getMensaje(), dato.getFecha());
    }

}
