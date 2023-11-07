package com.notaris.soro.services.impl;

import com.notaris.soro.dto.admin.TypePiecesDTO;
import com.notaris.soro.dto.admin.VilleDTO;
import com.notaris.soro.exceptions.EntityAlreadyExistException;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.admin.TypePieces;
import com.notaris.soro.models.admin.Ville;
import com.notaris.soro.repositories.TypePiecesRepository;
import com.notaris.soro.services.TypePiecesService;
import com.notaris.soro.validators.TypePiecesValidator;
import com.notaris.soro.validators.VilleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TypePiecesServiceImpl implements TypePiecesService {
    private final TypePiecesRepository typePiecesRepository;

    public TypePiecesServiceImpl(TypePiecesRepository typePiecesRepository) {
        this.typePiecesRepository = typePiecesRepository;
    }

    @Override
    public TypePiecesDTO save(TypePiecesDTO dto) {
        List<String> errors = TypePiecesValidator.validate(dto);
        if(dto == null){
            log.info("Objet null {]", dto);
        }if(typePiecesRepository.findByLibelle(dto.getLibelle()) != null){
            log.info("L'objet exite déjà");
            throw new InvalidEntityException("Une ville existe avec ce nom");
        }
        if(!errors.isEmpty()){
            log.info("objet invalide");
            throw new InvalidEntityException("L'objet fourni est invalide", errors);
        }
        return TypePiecesDTO.toEntityDTO(typePiecesRepository.save(TypePiecesDTO.toEntity(dto)));
    }

    @Override
    public TypePiecesDTO findById(Integer id) {
        if(id ==  null){
            log.info("L'id est null");
            throw  new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }if(typePiecesRepository.existsById(id) == true){
            log.info("la ville existe déjà");
            throw new EntityAlreadyExistException("La ville existe déjà");
        }
        return typePiecesRepository.findById(id).map(TypePiecesDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aunce ville trouvée avec cet id " + id);
        });
    }

    @Override
    public List<TypePiecesDTO> findAll() {
        return typePiecesRepository.findAll().stream().map(TypePiecesDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public TypePiecesDTO update(Integer id, TypePiecesDTO dto) {
        if(id ==  null) {
            log.info("L'id est null");
            throw new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }
        Optional<TypePieces> typePieces1 = typePiecesRepository.findById(id);
        if(typePieces1.isPresent()){
            TypePieces typePieces = typePieces1.get();
            typePieces.setLibelle(dto.getLibelle());
            return TypePiecesDTO.toEntityDTO(typePiecesRepository.save(typePieces));
        }
        throw  new EntityNotFoundException("Aucune Ville trouvée avec l'id " + id);

    }

    @Override
    public void delete(Integer id) {
        if(id ==  null) {
            log.info("L'id est null");
            throw new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }
        typePiecesRepository.deleteById(id);
    }
}
