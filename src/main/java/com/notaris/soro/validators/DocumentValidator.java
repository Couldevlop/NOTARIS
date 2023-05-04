package com.notaris.soro.validators;

import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.models.Documents;

import java.util.ArrayList;
import java.util.List;

public class DocumentValidator {

    public static List<String> validate(Documents dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("l'objet est invalid");
        }

        return errors;
    }
}
