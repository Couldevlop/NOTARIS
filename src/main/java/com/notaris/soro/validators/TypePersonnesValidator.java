package com.notaris.soro.validators;

import com.notaris.soro.dto.admin.TypePersonnesDTO;
import com.notaris.soro.dto.admin.TypeSuccessionsDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TypePersonnesValidator {

    public static List<String> validate(TypePersonnesDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
             errors.add("Objet inavlide");
             errors.add("Veillez saisir le nom du type de personne");
             return errors;

        }if(!StringUtils.hasLength(dto.getNom())){
            errors.add("veillez renseigner le nom");
        }

        return errors;
    }
}
