package com.notaris.soro.repositories;

import com.notaris.soro.models.liquidation.Communaute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommunauteRepository extends JpaRepository<Communaute, Integer> {
    Optional<Communaute> findByIntitule(String intitule);
}
