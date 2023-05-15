package com.notaris.soro.validators;

import com.notaris.soro.dto.NatureSocieteDTO;
import com.notaris.soro.dto.TypeDocumentDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NatureSocieteValidator {

    public static List<String> validate(NatureSocieteDTO dto){
        List<String> errors = new ArrayList<>();
        errors.add("l'objet est invalid");
        errors.add("Veillez renseigner le libelle");
        errors.add("Veillez renseigner la description");
        if(dto == null){
            errors.add("l'objet est invalid");
        }if(!StringUtils.hasLength(dto.getLibelle())){
            errors.add("Veillez renseigner le libelle");
        }if(!StringUtils.hasLength(dto.getDescription())){
            errors.add("Veillez renseigner la description");
        }

        return errors;
    }
}
