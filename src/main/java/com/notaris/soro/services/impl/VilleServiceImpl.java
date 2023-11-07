package com.notaris.soro.services.impl;

import com.notaris.soro.dto.admin.VilleDTO;
import com.notaris.soro.exceptions.EntityAlreadyExistException;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.admin.Ville;
import com.notaris.soro.repositories.VilleRepository;
import com.notaris.soro.services.VilleService;
import com.notaris.soro.validators.VilleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VilleServiceImpl implements VilleService {

    private final VilleRepository villeRepository;

    public VilleServiceImpl(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    @Override
    public VilleDTO save(VilleDTO dto) {
        List<String> errors = VilleValidator.validate(dto);
        if(dto == null){
            log.info("Objet null {]", dto);
        }if(villeRepository.findByNom(dto.getNom()) != null){
            log.info("L'objet exite déjà");
            throw new InvalidEntityException("Une ville existe avec ce nom");
        }
        if(!errors.isEmpty()){
            log.info("objet invalide");
            throw new InvalidEntityException("L'obket fourni est invalide", errors);
        }
        return VilleDTO.toEntityDTO(villeRepository.save(VilleDTO.toEntity(dto)));
    }

    @Override
    public VilleDTO findById(Integer id) {
        if(id ==  null){
            log.info("L'id est null");
            throw  new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }
        return villeRepository.findById(id).map(VilleDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aunce ville trouvée avec cet id " + id);
        });
    }

    @Override
    public List<VilleDTO> findAll() {
        return villeRepository.findAll().stream().map(VilleDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public VilleDTO update(Integer id, VilleDTO dto) {
        if(id ==  null) {
            log.info("L'id est null");
            throw new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }
       Optional<Ville> ville = villeRepository.findById(id);
        if(ville.isPresent()){
            Ville ville1 = ville.get();
            ville1.setNom(dto.getNom());
            return VilleDTO.toEntityDTO(villeRepository.save(ville1));
        }
        throw  new EntityNotFoundException("Aucune Ville trouvée avec l'id " + id);

    }

    @Override
    public void delete(Integer id) {
        if(id ==  null) {
            log.info("L'id est null");
            throw new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }
      villeRepository.deleteById(id);
    }
}
