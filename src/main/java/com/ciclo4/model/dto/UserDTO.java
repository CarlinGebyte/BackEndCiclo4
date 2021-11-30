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
     * Atributo identificación
     */
    private String identification;
    /**
     * Atributo birth Day
     */
    //private Date birthtDay;
    /**
     * Atributo Month birth day
     */
    //private String monthBirthtDay;
    /**
     * Atributo Name
     */
    private String name;
    /**
     * Atributo dirección
     */
    private String address;
    /**
     * Atributo teléfono
     */
    private String cellPhone;
    /**
     * Atributo Email
     */
    private String email;
    /**
     * Atributo Password
     */
    private String password;
    /**
     * Atributo zone
     */
    private String zone;
    /**
     * Atributo type
     */
    private String type;
}
