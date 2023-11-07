package com.notaris.soro.exceptions;

import lombok.Getter;

import java.util.List;

public class EntityAlreadyExistException extends RuntimeException{
   @Getter
    private List<String> errors;

    public EntityAlreadyExistException(String message) {
        super(message);
    }


    public EntityAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityAlreadyExistException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }




}
