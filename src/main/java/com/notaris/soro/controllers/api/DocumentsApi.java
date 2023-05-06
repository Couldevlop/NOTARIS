package com.notaris.soro.controllers.api;

import com.notaris.soro.models.Documents;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface DocumentsApi {

    Documents saveFile(MultipartFile file);
    Optional<Documents> getFile(Integer fileId);
    List<Documents> getFiles();
}
