package com.notaris.soro.repositories;

import com.notaris.soro.models.liquidation.Sucession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SucessionRepository extends JpaRepository<Sucession, Integer> {
    Optional<Sucession> findByIntitule(String intitule);
}
