package com.camberos.challengeforohub.model.DTO;

import com.camberos.challengeforohub.model.Entity.Curso;

public record CursoRespuestaDTO(Long id, String nombre) {

    public CursoRespuestaDTO(Curso curso){
        this(curso.getId(),curso.getNombre());
    }
}
