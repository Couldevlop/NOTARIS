package com.notaris.soro.repositories;

import com.notaris.soro.dto.TypeSocieteDTO;
import com.notaris.soro.models.societe.TypeSociete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeSocieteRepository extends JpaRepository<TypeSociete, Integer> {
    Optional<TypeSociete> findByLibelle(String sigle);
}
