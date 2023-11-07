package com.notaris.soro.repositories;

import com.notaris.soro.models.Documents;
import com.notaris.soro.models.DocumentsModifSociete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentModifSocieteRepository extends JpaRepository<DocumentsModifSociete, Integer> {
    List<DocumentsModifSociete> findAllByModifscte(Integer id);

    Documents findByDocName(String name);

}
