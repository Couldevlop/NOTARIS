package com.notaris.soro.repositories;

import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.models.Banque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BanqueRepository extends JpaRepository<Banque, Integer> {
    Optional<Banque> findBySigle(String sigle);
}
