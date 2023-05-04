package com.notaris.soro.validators;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.models.ActeImmobilier;

import java.util.ArrayList;
import java.util.List;

public class ActeImmobilierValidator {

    public static List<String> validate(ActeImmobilierDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("l'objet est invalid");
        }

        return errors;
    }
}
