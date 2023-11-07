package com.notaris.soro.repositories;

import com.notaris.soro.models.societe.Creation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConstitutionRepository extends JpaRepository<Creation, Integer> {
    Optional<Creation> findByIntitule(String libelle);
    Creation findCreationByIntitule(String intitule);
}
