package com.notaris.soro.validators;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.models.ActeImmobilier;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ActeImmobilierValidator {

    public static List<String> validate(ActeImmobilierDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("Veillez renseigner l'acquereur");
            errors.add("Veillez renseigner vendeur ");
            errors.add("Veillez renseigner l'intitulé");
            errors.add("Veillez renseigner le type d'action immobilier");
            errors.add("Veillez renseigner le commentaire");
        }
        if(!StringUtils.hasLength(dto.getAcquereur())){
            errors.add("Veillez renseigner l'acquereur");
        }if(!StringUtils.hasLength(dto.getVendeur())){
            errors.add("Veillez renseigner vendeur ");
        }if(!StringUtils.hasLength(dto.getIntitule())){
            errors.add("Veillez renseigner l'intitulé");
        }if(!StringUtils.hasLength(dto.getTypeActeImmo().name())){
            errors.add("Veillez renseigner le type d'action immobilier");
        }if(!StringUtils.hasLength(dto.getCommentaire())){
            errors.add("Veillez renseigner le commentaire");
        }

        return errors;
    }
}
