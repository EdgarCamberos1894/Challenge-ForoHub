package com.camberos.challengeforohub.repository;

import com.camberos.challengeforohub.model.Entity.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Page<Topico> findAllByOrderByFechaCreacionAsc(Pageable pageable);


}
