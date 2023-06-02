package com.notaris.soro.services.impl;

import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.Documents;
import com.notaris.soro.repositories.BanqueRepository;
import com.notaris.soro.services.BanqueService;
import com.notaris.soro.validators.BanqueValidator;
import jakarta.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;



@Service
@Slf4j

public class BanqueServiceImpl implements BanqueService {
    @Autowired
    ServletContext context;
    private final BanqueRepository banqueRepository;
    private final DocumentServiceImpl documentService;
    private final Path root = Paths.get("uploads");

    public BanqueServiceImpl(BanqueRepository banqueRepository, DocumentServiceImpl documentService) {
        this.banqueRepository = banqueRepository;
        this.documentService = documentService;
    }

    @Override
    public BanqueDTO save(MultipartFile file, BanqueDTO dto) throws IOException {

        List<String> errors = BanqueValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("l'objet fourni est invalid");
            throw new InvalidEntityException("Objet invalid",errors);
        }
        if(file == null){
            log.info("l'objet fournit est invalide");
            throw new InvalidEntityException("L'objet fournit est invalide");
        }
        Documents doc = documentService.saveFile(file);

         String url = context.getRealPath("/upload")+file.getOriginalFilename();
         dto.setLogo(url);
        return BanqueDTO.toEntityDTO(banqueRepository.save(BanqueDTO.toEntity(dto)));
    }

    @Override
    public BanqueDTO create(BanqueDTO dto) {
        List<String> errors = BanqueValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("l'objet fourni est invalid");
            throw new InvalidEntityException("Objet invalid",errors);
        }

        return BanqueDTO.toEntityDTO(banqueRepository.save(BanqueDTO.toEntity(dto)));
    }

    @Override
    public BanqueDTO findById(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("Impossible de trouver un client Banque avec un id null");
        }
        return banqueRepository.findById(id).map(BanqueDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucun client Banque n'a été retrouvé avec l'id" + id);
        });
    }

    @Override
    public List<BanqueDTO> findAll() {
        return banqueRepository.findAll().stream().map(BanqueDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public BanqueDTO findBySigle(String sigle) {
        if(sigle == null){
            log.info("le nom est vide");
            throw new EntityNotFoundException("Impossible de trouver un client Banque avec un id null");
        }
        return banqueRepository.findBySigle(sigle).map(BanqueDTO::toEntityDTO).orElseThrow(()->{
            throw  new EntityNotFoundException("Aucune client banque n'a été trouvé avec le sigle suivant" + sigle);
        });
    }

    @Override
    public void delete(Integer id) {
       banqueRepository.deleteById(id);
    }
}
