package com.notaris.soro.validators;

import com.notaris.soro.dto.admin.PaysDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PaysValidator {

    public static List<String> validate(PaysDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
             errors.add("Objet invalide");
            errors.add("Veillez renseigner le nom du pays");
            return errors;
        }if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veillez renseigner le nom du pays");
        }

        return errors;
    }
}
