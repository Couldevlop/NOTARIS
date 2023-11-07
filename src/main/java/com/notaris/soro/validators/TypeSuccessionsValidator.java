package com.notaris.soro.validators;

import com.notaris.soro.dto.admin.PaysDTO;
import com.notaris.soro.dto.admin.TypeSuccessionsDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TypeSuccessionsValidator {

    public static List<String> validate(TypeSuccessionsDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
             errors.add("Veillez saisir le nom du type de succession");
             errors.add("veillez renseigner le nom");
             return errors;
        }if(!StringUtils.hasLength(dto.getLibelle())){
            errors.add("veillez renseigner le nom");
        }

        return errors;
    }
}
