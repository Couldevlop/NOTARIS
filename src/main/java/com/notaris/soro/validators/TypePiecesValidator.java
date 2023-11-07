package com.notaris.soro.validators;

import com.notaris.soro.dto.admin.TypePersonnesDTO;
import com.notaris.soro.dto.admin.TypePiecesDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TypePiecesValidator {

    public static List<String> validate(TypePiecesDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
             errors.add("Veillez saisir le nom du type de personne");
             errors.add("veillez renseigner le nom");
             return errors;
        }if(!StringUtils.hasLength(dto.getLibelle())){
            errors.add("veillez renseigner le nom");
        }

        return errors;
    }
}
