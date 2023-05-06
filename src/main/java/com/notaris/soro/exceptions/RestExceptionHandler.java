package com.notaris.soro.exceptions;

import com.notaris.soro.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(EntityNotFoundException exception, WebRequest webRequest){
           final HttpStatus notfound = HttpStatus.NOT_FOUND;
           final ErrorDTO errorDTO = ErrorDTO.builder()
                   .httpCode(notfound.value())
                   .message(exception.getMessage()).build();

           return new ResponseEntity<>(errorDTO, notfound);
    }
}