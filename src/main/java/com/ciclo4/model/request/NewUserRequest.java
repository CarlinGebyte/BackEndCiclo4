package com.ciclo4.model.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class NewUserRequest {

    /**
     * Atributo Id
     */
    private Integer id;
    /**
     * Atributo identificación
     */
    private String identification;
    /**
     * Atributo birth Day
     */
    private Date birthtDay;
    /**
     * Atributo Month birth day
     */
    private String monthBirthtDay;
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
     * Atributo Name
     */
    private String name;
    /**
     * Atributo zone
     */
    private String zone;
    /**
     * Atributo type
     */
    private String type;
}
