package com.notaris.soro.validators;

import com.notaris.soro.models.Documents;
import com.notaris.soro.models.DocumentsSuccession;

import java.util.ArrayList;
import java.util.List;

public class DocumentsSuccessionValidator {

    public static List<String> validate(DocumentsSuccession dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("l'objet est invalid");
        }

        return errors;
    }
}
