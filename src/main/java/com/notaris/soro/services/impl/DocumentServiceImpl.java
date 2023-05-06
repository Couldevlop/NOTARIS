package com.notaris.soro.services.impl;

import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.dto.MoralDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.Documents;
import com.notaris.soro.models.TypeDocument;
import com.notaris.soro.repositories.DocumentRepository;
import com.notaris.soro.services.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {


    private DocumentRepository docRepository;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final Path rootLocation = Paths.get("C:\\Users\\Public\\webservice\\sysgescom");
    //private final Path rootLocation = Paths.get("filestorage");





    public DocumentsDTO saveFile(MultipartFile file) {
        String docname = file.getOriginalFilename();
        try {
            Files.copy(file.getInputStream(),
                    this.rootLocation.resolve(file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            Documents doc = new Documents();
            doc.setTypeDocument(null);
            doc.setDocType(file.getContentType());
            doc.setDocName(docname);
            doc.setDossierId(null);
            doc.setId(null);
            return DocumentsDTO.toEntityDTO(docRepository.save(doc));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public DocumentsDTO getFile(Integer fileId)
    {
        //return DocumentsDTO.toEntity(docRepository.findById(fileId));
        return null;
    }
    public List<DocumentsDTO> getFiles(){
        //return docRepository.findAll();
        return null;
    }
}
