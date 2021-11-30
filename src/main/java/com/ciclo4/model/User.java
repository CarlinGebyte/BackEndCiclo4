package com.ciclo4.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author CarlinGebyte
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
@Document(collection = "usuarios")
public class User {
    /**
     * Atributo ID
     */
    @Id
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

