package com.ciclo4.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * @author CarlinGebyte
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
@Document(collection = "user")
public class User {
    /**
     * Atributo ID
     */
    @Id
    private Integer id;
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
}

/**
 * @Data
 * @NoArgsConstructor
 * @AllArgsConstructor
 * @Document(collection = "usuarios")
 * public class User{
 *
 *     @Id
 *     private Integer id;
 *     private String identification;
 *     private String name;
 *     private Date birthtDay;
 *     private String monthBirthtDay;
 *     private String address;
 *     private String cellPhone;
 *     private String email;
 *     private String password;
 *     private String zone;
 *     private String type;
 *
 * }
 */