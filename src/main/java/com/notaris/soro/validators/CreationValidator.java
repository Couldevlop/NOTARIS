package com.notaris.soro.validators;

import com.notaris.soro.dto.CreationDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CreationValidator {
    private List<String> validate(CreationDTO dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veillez renseigner le commentaire");
            errors.add("Veillez renseigner l'intitulé");
            errors.add("Veillez renseigner la date d'ouverture");
            errors.add("Veillez renseigner la nature de la societé");
            errors.add("Veillez renseigner le type de société");
            errors.add("Veillez renseigner le type le client");

        }if(!StringUtils.hasLength(dto.getCommentaire())){
            errors.add("Veillez renseigner le commentaire");
        }if(!StringUtils.hasLength(dto.getIntitule())){
            errors.add("Veillez renseigner l'intitulé");
        }if(dto.getDateOuverture() == null){
            errors.add("Veillez renseigner la date d'ouverture");
        }if(dto.getNatureSociete() == null){
            errors.add("Veillez renseigner la nature de la societé");
        }if(dto.getTypeSociete() == null){
            errors.add("Veillez renseigner le type de société");
        }if(dto.getPhysique() == null){
            errors.add("Veillez renseigner le type le client");
        }

        return  errors;
    }
}
