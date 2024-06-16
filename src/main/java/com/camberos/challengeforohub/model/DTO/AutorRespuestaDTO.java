package com.camberos.challengeforohub.model.DTO;

import com.camberos.challengeforohub.model.Entity.Usuario;

public record AutorRespuestaDTO(Long id, String nombre) {

    public AutorRespuestaDTO(Usuario autor){
        this(autor.getId(),autor.getNombre());
    }
}
