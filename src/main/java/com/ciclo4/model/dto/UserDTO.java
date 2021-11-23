package com.ciclo4.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    /**
     * Atributo ID
     */
    private Integer id;
    /**
     * Atributo correo
     */
    private String email;
    /**
     * Atributo Password
     */
    private String password;
    /**
     * Atributo nombre
     */
    private String name;
}
