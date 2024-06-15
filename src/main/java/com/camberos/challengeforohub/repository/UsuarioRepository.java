package com.camberos.challengeforohub.repository;

import com.camberos.challengeforohub.model.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    UserDetails findByCorreoElectronico(String correroElectronico);
}
