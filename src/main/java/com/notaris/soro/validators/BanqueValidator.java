package com.notaris.soro.validators;

import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.dto.PhysiqueDTO;

import java.util.ArrayList;
import java.util.List;

public class BanqueValidator {

    public static List<String> validate(BanqueDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("l'objet est invalid");
        }

        return errors;
    }
}
