package com.notaris.soro.validators;

import com.notaris.soro.dto.PhysiqueDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PhysiqueValidator {

    public static List<String> validate(PhysiqueDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("Veillez renseigner l'eamil");
            errors.add("Veillez renseigner le nom de la personne");
            errors.add("Veillez renseigner le prenom de la personne");
            errors.add("Veillez renseigner le numéro du téléphone mobile");
            errors.add("Veillez renseigner le lieu de travail");
            errors.add("Veillez renseigner la date de naissance");

        }if(!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veillez renseigner l'eamil");
        }if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veillez renseigner le nom de la personne");
        }if(!StringUtils.hasLength(dto.getPrenom())){
            errors.add("Veillez renseigner le prenom de la personne");
        }if(!StringUtils.hasLength(dto.getMobile())){
            errors.add("Veillez renseigner le numéro du téléphone mobile");
        }if(!StringUtils.hasLength(dto.getLieuDeTravail())){
            errors.add("Veillez renseigner le lieu de travail");
        }if(!StringUtils.hasLength(dto.getDateNaissance().toString())){
            errors.add("Veillez renseigner la date de naissance");
        }if(dto.getAdresse() == null){
            errors.addAll(AdresseValidator.validate(dto.getAdresse()));
        }

        return errors;
    }
}
