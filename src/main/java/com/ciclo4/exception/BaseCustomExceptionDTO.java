package com.ciclo4.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseCustomExceptionDTO {
    /**
     * Atributo Mensaje
     */
    private String message;
    /**
     * Atributo ErrorCode
     */
    private int errorCode;
}
