package com.notaris.soro.repositories;

import com.notaris.soro.models.DocumentsCommunaute;
import com.notaris.soro.models.DocumentsSuccession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentCommunauteRepository extends JpaRepository<DocumentsCommunaute, Integer> {
    List<DocumentsCommunaute> findAllByDoccommunuateId(Integer id);

    DocumentsCommunaute findByDocName(String name);

}
