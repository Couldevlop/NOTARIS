package com.notaris.soro.validators;

import com.notaris.soro.dto.OuvertureCreditDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OuvertureCreditValidator {
    public static List<String> Validation(OuvertureCreditDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("Veillez renseigner l'intitulé de l'ouverture de credit");
            errors.add("Veillez renseigner le montant du credit");
            errors.add("Veillez renseigner le client");
            errors.add("Veillez renseigner le commentaire");
            errors.add("Veillez renseigner la date d'ouverture");
            errors.add("Veillez renseigner le nom du gestionnaire");
            errors.add("Veillez renseigner le taux applicable");
            return errors;
        }if(!StringUtils.hasLength(dto.getIntitule())){
            errors.add("Veillez renseigner l'intitulé de l'ouverture de credit");
        }if(!StringUtils.hasLength(dto.getCommentaire())){
            errors.add("VeIllez renseigner le type de successions");
        }if(!StringUtils.hasLength(dto.getClient())){
            errors.add("Veillez renseigner le client");
        }if(!StringUtils.hasLength(dto.getGestionnaire())){
            errors.add("Veillez renseigner le nom du gestionnaire");
        }if(dto.getTaux() == 0){
            errors.add("Veillez renseigner le taux applicable");
        }if(dto.getMontant() == 0){
            errors.add("Veillez renseigner le montant du credit");
        }
        return errors;
    }
}
