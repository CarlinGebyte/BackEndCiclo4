package com.ciclo4.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseCustomException extends RuntimeException{

    private final int errorCode;

    public BaseCustomException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
