package com.ciclo4.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseCustomExceptionDTO {
    private String message;
    private int errorCode;
}
