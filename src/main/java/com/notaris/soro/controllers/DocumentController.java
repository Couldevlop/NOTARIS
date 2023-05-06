package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.DocumentsApi;
import com.notaris.soro.models.Documents;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
public class DocumentController implements DocumentsApi {
    @Override
    public Documents saveFile(MultipartFile file) {
        return null;
    }

    @Override
    public Optional<Documents> getFile(Integer fileId) {
        return Optional.empty();
    }

    @Override
    public List<Documents> getFiles() {
        return null;
    }
}
