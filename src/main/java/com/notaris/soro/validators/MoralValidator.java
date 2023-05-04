package com.notaris.soro.validators;

import com.notaris.soro.dto.MoralDTO;
import com.notaris.soro.dto.PhysiqueDTO;

import java.util.ArrayList;
import java.util.List;

public class MoralValidator {

    public static List<String> validate(MoralDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("l'objet est invalid");
        }

        return errors;
    }
}
