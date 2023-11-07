package com.notaris.soro.validators;

import com.notaris.soro.dto.SuccessionDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SucessionValidator {
    
    public static List<String> validate(SuccessionDTO dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veillez renseigner le commentaire");
            errors.add("Veillez renseigner l'intitulé");
            errors.add("Veillez renseigner la date d'ouverture");
            errors.add("Veillez sélectionner un client");

        }if(!StringUtils.hasLength(dto.getCommentaire())){
            errors.add("Veillez renseigner le commentaire");
        }if(!StringUtils.hasLength(dto.getIntitule())){
            errors.add("Veillez renseigner l'intitulé");
        }if(!StringUtils.hasLength(String.valueOf(dto.getDateOuverture() == null))){
            errors.add("Veillez renseigner la date d'ouverture");
        }if(dto.getTypeSuccession() == null){
            errors.add("Veillez renseigner le type de session");
        };

            return errors;
    }

}
