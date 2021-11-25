package com.ciclo4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalBack4ExceptionHandler {

    /**
     * ExceptionHandler
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BaseCustomExceptionDTO> basicCustomException(BaseCustomException ex) {
        return ResponseEntity.badRequest().body(BaseCustomExceptionDTO.builder()
                .errorCode(ex.getErrorCode())
                .message(ex.getMessage())
                .build());
    }
}
