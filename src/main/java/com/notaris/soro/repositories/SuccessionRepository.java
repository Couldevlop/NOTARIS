package com.notaris.soro.repositories;

import com.notaris.soro.models.liquidation.Succession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuccessionRepository extends JpaRepository<Succession, Integer> {
    Optional<Succession> findByIntitule(String intitule);
}
