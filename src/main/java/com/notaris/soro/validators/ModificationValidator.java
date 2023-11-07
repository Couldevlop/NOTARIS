package com.notaris.soro.validators;

import com.notaris.soro.dto.CreationDTO;
import com.notaris.soro.dto.ModificationDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ModificationValidator {
    public static List<String> validate(ModificationDTO dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veillez renseigner le objet");
            errors.add("Veillez renseigner motif");
            errors.add("Veillez renseigner la date d'ouverture");
            errors.add("Veillez renseigner la nature de la societé");
            errors.add("Veillez renseigner le type de société");
            errors.add("Veillez renseigner le type le client");
            return errors;

        }if(!StringUtils.hasLength(dto.getObjet())){
            errors.add("Veillez renseigner l'objet");
        }if(!StringUtils.hasLength(dto.getMotif())){
            errors.add("Veillez renseigner le motif");
        }if(dto.getDateOuverture() == null){
            errors.add("Veillez renseigner la date d'ouverture");
        }if(!StringUtils.hasLength(dto.getNatureSociete())){
            errors.add("Veillez renseigner la nature de la societé");
        }if(!StringUtils.hasLength(dto.getTypeSociete())){
            errors.add("Veillez renseigner le type de société");
        }if(!StringUtils.hasLength(dto.getClient())){
            errors.add("Veillez renseigner le type le client");
        }

        return  errors;
    }
}
