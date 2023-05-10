package com.notaris.soro.repositories;

import com.notaris.soro.models.clients.Physique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhysiqueRepository extends JpaRepository<Physique, Integer> {
    Optional<Physique> findByEmail(String email);
    Optional<Physique> findByNom(String nom);
}
