package com.notaris.soro.validators;

import com.notaris.soro.dto.admin.PaysDTO;
import com.notaris.soro.dto.admin.VilleDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VilleValidator {

    public static List<String> validate(VilleDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("Objet non valide");
             errors.add("Veillez saisir le nom du pays");
             return errors;
        }if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veillez saisir le nom du pays");
        }

        return errors;
    }
}
