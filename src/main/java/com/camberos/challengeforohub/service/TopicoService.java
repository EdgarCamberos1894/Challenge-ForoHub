package com.camberos.challengeforohub.service;

import com.camberos.challengeforohub.infra.errores.ApplicationException;
import com.camberos.challengeforohub.model.DTO.TopicoActualizaDTO;
import com.camberos.challengeforohub.model.DTO.TopicoRegistroDTO;
import com.camberos.challengeforohub.model.Entity.Curso;
import com.camberos.challengeforohub.repository.CursoRepository;
import com.camberos.challengeforohub.repository.TopicoRepository;
import com.camberos.challengeforohub.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TopicoService {

    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;
    private final TopicoRepository topicoRepository;

    public TopicoService(UsuarioRepository usuarioRepository, CursoRepository cursoRepository, TopicoRepository topicoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
        this.topicoRepository = topicoRepository;
    }

    public void verificarDuplicados(TopicoRegistroDTO datosRegistroTopico) {
        if (topicoRepository.existsByTituloAndMensaje(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje())) {
            throw new ApplicationException("Ya existe un tópico con el mismo título y mensaje");
        }
    }

    public Curso verificarExistenciaDeCurso(Long idCurso) {
        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new ApplicationException("Curso con ID " + idCurso + " no encontrado"));
        return curso;
    }

    public void verificarSiEsElAutorDelTopico(Long topicoActualizaDTO, Long idUsuarioAutenticado) {
        if (!Objects.equals(topicoActualizaDTO, idUsuarioAutenticado)){
            throw new ApplicationException("No tiene permiso para modificar este Topico");
        }
    }
}
