package com.notaris.soro.services.impl;

import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.repositories.BanqueRepository;
import com.notaris.soro.services.BanqueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.sun.tools.javac.util.StringUtils.toUpperCase;


@Service
@Slf4j
@RequiredArgsConstructor
public class BanqueServiceImpl implements BanqueService {

    private BanqueRepository banqueRepository;
    @Override
    public BanqueDTO save(BanqueDTO dto) {
        if(dto == null){
            log.info("l'objet fourni est invalid");
            throw new InvalidEntityException("Objet invalid");
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
    public List<BanqueDTO> findAll(BanqueDTO dto) {
        return banqueRepository.findAll().stream().map(BanqueDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public BanqueDTO findBySigle(String sigle) {
        if(sigle == null){
            log.info("le nom est vide");
            throw new EntityNotFoundException("Impossible de trouver un client Banque avec un id null");
        }
        return banqueRepository.findBySigle(toUpperCase(sigle)).map(BanqueDTO::toEntityDTO).orElseThrow(()->{
            throw  new EntityNotFoundException("Aucune client banque n'a été trouvé avec le sigle suivant" + sigle);
        });
    }

    @Override
    public void delete(Integer id) {
       banqueRepository.deleteById(id);
    }
}
