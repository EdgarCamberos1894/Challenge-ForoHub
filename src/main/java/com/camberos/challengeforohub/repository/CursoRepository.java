package com.camberos.challengeforohub.repository;

import com.camberos.challengeforohub.model.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
