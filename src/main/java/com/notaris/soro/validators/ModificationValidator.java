package com.notaris.soro.validators;

import com.notaris.soro.dto.CreationDTO;
import com.notaris.soro.dto.ModificationDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ModificationValidator {
    private List<String> validate(ModificationDTO dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veillez renseigner le objet");
            errors.add("Veillez renseigner motif");
            errors.add("Veillez renseigner la date d'ouverture");
            errors.add("Veillez renseigner la nature de la societé");
            errors.add("Veillez renseigner le type de société");
            errors.add("Veillez renseigner le type le client");

        }if(!StringUtils.hasLength(dto.getObjet())){
            errors.add("Veillez renseigner l'objet");
        }if(!StringUtils.hasLength(dto.getMotif())){
            errors.add("Veillez renseigner le motif");
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
