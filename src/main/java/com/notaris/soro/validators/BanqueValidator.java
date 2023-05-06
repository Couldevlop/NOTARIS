package com.notaris.soro.validators;

import com.notaris.soro.dto.AdresseDTO;
import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.dto.PhysiqueDTO;

import java.util.ArrayList;
import java.util.List;

public class BanqueValidator {

    public static List<String> validate(BanqueDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("l'objet est invalid");
            errors.add("veillez renseigner le sigle");
            errors.add("veillez renseigner la raison sociale");
            errors.add("veille renseigner la nature de la banque");
            errors.add("veillez renseigner l'activité");
            errors.add("veillez renseigner le numéro RCCM");
            errors.add("veillez renseigner la DFE");
            errors.add("veillez importer le logo");
            errors.add("veillez renseigner le fix");
            errors.addAll(AdresseValidator.validate(dto.getAdresse()));
        }

        return errors;
    }
}
