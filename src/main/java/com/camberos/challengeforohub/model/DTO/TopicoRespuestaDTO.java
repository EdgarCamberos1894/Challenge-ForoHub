package com.camberos.challengeforohub.model.DTO;

import com.camberos.challengeforohub.model.Entity.Topico;

import java.time.LocalDateTime;

public record TopicoRespuestaDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime FechaCreacion,
        AutorRespuestaDTO autor,
        CursoRespuestaDTO curso ) {


    public TopicoRespuestaDTO(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                new AutorRespuestaDTO(topico.getAutor()),
                new CursoRespuestaDTO(topico.getCurso())
        );
    }
}
