package com.ciclo4.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewUserRequest {

    /**
     * Atributo Id
     */
    private Integer id;
    /**
     * Atributo email
     */
    private String email;
    /**
     * Atributo password
     */
    private String password;
    /**
     * Atributo name
     */
    private String name;
}
