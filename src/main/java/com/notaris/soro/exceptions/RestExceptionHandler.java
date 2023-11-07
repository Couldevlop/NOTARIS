package com.notaris.soro.exceptions;

import com.notaris.soro.dto.ErrorDTO;
import com.notaris.soro.models.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
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

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleException(EntityAlreadyExistException exception, WebRequest webRequest){
        final HttpStatus alreadyExiste = HttpStatus.ALREADY_REPORTED;
        ErrorDTO errorDTO = ErrorDTO.builder()
                .message(exception.getMessage())
                .httpCode(alreadyExiste.value())
                .build();
        return  new ResponseEntity<>( errorDTO, alreadyExiste);
    }

   /* @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseMessage("One or more files are too large!"));
    }
*/
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
    }
}
