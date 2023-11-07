package com.notaris.soro.services.impl;

import com.notaris.soro.dto.admin.PaysDTO;
import com.notaris.soro.dto.admin.RolesDTO;
import com.notaris.soro.enums.ERole;
import com.notaris.soro.exceptions.EntityAlreadyExistException;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.Role;
import com.notaris.soro.models.admin.Pays;
import com.notaris.soro.repositories.RoleRepository;
import com.notaris.soro.services.RolesService;
import com.notaris.soro.validators.PaysValidator;
import com.notaris.soro.validators.RolesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RolesServiceImpl implements RolesService {
    private final RoleRepository roleRepository;

    public RolesServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public RolesDTO save(RolesDTO dto) {
        List<String> errors = RolesValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("Objet invalide {}", dto);
            throw new InvalidEntityException("L'objet fourni est invalide", errors);
        }
        if(roleRepository.findByName(ERole.valueOf(dto.getNom())).isPresent()){
            throw new EntityAlreadyExistException("Un pays existe avec ce nom: " + dto.getNom(), errors);
        }
        return RolesDTO.toEntityDTO(roleRepository.save(RolesDTO.toDTOEntity(dto)));
    }

    @Override
    public RolesDTO findById(Integer id) {
        if(id == null){
            log.info("l'id fourni est null");
            throw new EntityNotFoundException("Impossible de trouver un resultat avec un id null");
        }if(roleRepository.existsById(id) == true){
            throw new EntityAlreadyExistException("Un pays existe déjà");
        }
        return roleRepository.findById(id).map(RolesDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucun resultat n'a été trouvé avec l'id " + id);
        });
    }

    @Override
    public List<RolesDTO> findAll() {
        return roleRepository.findAll().stream().map(RolesDTO::toEntityDTO).collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        if(id == null){
            log.info("l'id fourni est null");
            throw new EntityNotFoundException("Impossible de trouver un resultat avec un id null");
        }
     roleRepository.deleteById(id);
    }
}
