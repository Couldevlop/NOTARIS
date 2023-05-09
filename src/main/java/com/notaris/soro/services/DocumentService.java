package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.models.Documents;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public interface DocumentService {
    public Documents store(MultipartFile[] file) throws IOException;
    public Documents getFile(Integer id);
     public Stream<Documents> getAllFiles();



}
