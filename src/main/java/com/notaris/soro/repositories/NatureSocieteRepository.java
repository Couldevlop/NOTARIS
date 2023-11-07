package com.notaris.soro.repositories;

import com.notaris.soro.models.admin.NatureSociete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NatureSocieteRepository extends JpaRepository<NatureSociete, Integer> {
    Optional<NatureSociete> findByLibelle(String libelle);
}
