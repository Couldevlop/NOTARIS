package com.notaris.soro.repositories;

import com.notaris.soro.models.Documents;
import com.notaris.soro.models.DocumentsSuccession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentSuccesionRepository extends JpaRepository<DocumentsSuccession, Integer> {
    List<DocumentsSuccession> findAllBydocsuccessionId(Integer id);

    DocumentsSuccession findByDocName(String name);

}
