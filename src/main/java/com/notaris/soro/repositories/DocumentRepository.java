package com.notaris.soro.repositories;

import com.notaris.soro.models.ActeImmobilier;
import com.notaris.soro.models.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Documents, Integer> {
    List<Documents> findAllByActeimmoId(Integer id);

    Documents findByDocName(String name);

}
