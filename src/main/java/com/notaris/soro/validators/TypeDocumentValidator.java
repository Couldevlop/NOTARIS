package com.notaris.soro.validators;

import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.dto.TypeDocumentDTO;
import com.notaris.soro.models.TypeDocument;

import java.util.ArrayList;
import java.util.List;

public class TypeDocumentValidator {

    public static List<String> validate(TypeDocumentDTO dto){
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("l'objet est invalid");
        }

        return errors;
    }
}
