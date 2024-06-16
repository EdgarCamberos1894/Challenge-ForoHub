package com.camberos.challengeforohub.controller;

import com.camberos.challengeforohub.model.DTO.DatosAutenticacionUsuarioDTO;
import com.camberos.challengeforohub.model.DTO.DatosJWTTokenDTO;
import com.camberos.challengeforohub.model.Entity.Usuario;
import com.camberos.challengeforohub.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(("/login"))
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Autenticacion")
public class AutenticacionController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    public AutenticacionController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    @Operation(summary = "obtiene el token para el usuario asignado que da acceso al resto de endpoint")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuarioDTO datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.correoElectronico(),
                datosAutenticacionUsuario.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTTokenDTO(JWTtoken));
    }

}
