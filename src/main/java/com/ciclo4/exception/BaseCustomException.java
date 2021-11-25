package com.ciclo4.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseCustomException extends RuntimeException {

    /**
     * Atributo ErrrorCode
     */
    private final int errorCode;

    /**
     * Método constructor
     *
     * @param message
     * @param errorCode
     */
    public BaseCustomException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
