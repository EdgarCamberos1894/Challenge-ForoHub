package com.camberos.challengeforohub.controller;

import com.camberos.challengeforohub.infra.errores.ApplicationException;
import com.camberos.challengeforohub.model.DTO.TopicoActualizaDTO;
import com.camberos.challengeforohub.model.DTO.TopicoRegistroDTO;
import com.camberos.challengeforohub.model.DTO.TopicoRespuestaDTO;
import com.camberos.challengeforohub.model.Entity.Curso;
import com.camberos.challengeforohub.model.Entity.Topico;
import com.camberos.challengeforohub.model.Entity.Usuario;
import com.camberos.challengeforohub.repository.TopicoRepository;
import com.camberos.challengeforohub.repository.UsuarioRepository;
import com.camberos.challengeforohub.security.TokenService;
import com.camberos.challengeforohub.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class TopicoController {

    private final TopicoRepository topicoRepository;
    private final TopicoService topicoService;
    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    public TopicoController(TopicoRepository topicoRepository, TopicoService topicoService, TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.topicoRepository = topicoRepository;
        this.topicoService = topicoService;
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("topicos/{id}")
    public ResponseEntity<TopicoRespuestaDTO> getTopic(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isEmpty()) {
            throw new ApplicationException("No se encontro el tipico con id:" + id);
        }
        Topico topico = topicoOptional.get();

        TopicoRespuestaDTO topicoDTO = new TopicoRespuestaDTO(topico);

        return ResponseEntity.ok(topicoDTO);
    }

    @PostMapping("/topicos")
    @Transactional
    public ResponseEntity<TopicoRespuestaDTO> saveTopic(@RequestHeader("Authorization") String token,
                                                        @RequestBody @Valid TopicoRegistroDTO datosRegistroTopico,
                                                        UriComponentsBuilder uriComponentsBuilder) {

        token = token.replace("Bearer ", "");
        topicoService.verificarDuplicados(datosRegistroTopico);
        Curso curso = topicoService.verificarExistenciaDeCurso(datosRegistroTopico.curso());
        Usuario autor = usuarioRepository.getReferenceById(tokenService.getId(token));

        Topico topico = new Topico(datosRegistroTopico.titulo(),datosRegistroTopico.mensaje(),autor,curso);
        topicoRepository.save(topico);

        TopicoRespuestaDTO datosRespuestaTopico = new TopicoRespuestaDTO(topico);

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping("/topicos")
    public ResponseEntity getTopicos(@PageableDefault(10) Pageable pageable) {
        return ResponseEntity.ok(topicoRepository.findAllByOrderByFechaCreacionAsc(pageable).map(TopicoRespuestaDTO::new));
    }


    @DeleteMapping("/topicos/{id}")
    public ResponseEntity deleteTopicos(@PathVariable Long id){
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping("/topicos/{id}")
    public ResponseEntity updateTopicos(@RequestHeader("Authorization") String token,
                                        @PathVariable Long id,
                                        @RequestBody @Valid TopicoRegistroDTO topicoRegistroDTO){

        token = token.replace("Bearer ", "");
        Topico topico = topicoRepository.getReferenceById(id);
        Curso curso = topicoService.verificarExistenciaDeCurso(topicoRegistroDTO.curso());
        topicoService.verificarSiEsElAutorDelTopico(topico.getAutor().getId(), tokenService.getId(token));

        topico.actualizarTopico(topicoRegistroDTO.titulo(),topicoRegistroDTO.mensaje(),curso);

        return ResponseEntity.ok(new TopicoRespuestaDTO(topico));
    }






}
