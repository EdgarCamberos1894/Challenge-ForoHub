package com.camberos.challengeforohub.model.DTO;

import com.camberos.challengeforohub.model.Entity.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoActualizaDTO(
        @NotNull
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Long  curso

) {
}
