package com.notaris.soro.validators;

import com.notaris.soro.dto.admin.NatureSocieteDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NatureSocieteValidator {

    public static List<String> validate(NatureSocieteDTO dto){
        List<String> errors = new ArrayList<>();
        if (dto == null){
            errors.add("l'objet est invalid");
            errors.add("Veillez renseigner le libelle");
            errors.add("Veillez renseigner la description");
            return errors;
        }if(!StringUtils.hasLength(dto.getLibelle())){
            errors.add("Veillez renseigner le libelle");
        }if(!StringUtils.hasLength(dto.getDescription())){
            errors.add("Veillez renseigner la description");
        }

        return errors;
    }
}
