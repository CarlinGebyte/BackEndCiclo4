package com.ciclo4.model;


import lombok.*;

import javax.persistence.*;

/**
 * @author CarlinGebyte
 */
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    /**
     * Atributo ID
     */
    @Id // sirve para definir el identificador único de cada Entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    /**
     * Atributo Correo
     */
    @Column(name = "user_email",length = 50,unique = true, nullable = false)
    private String email;
    /**
     * Atributo Password
     */
    @Column(name = "user_password", length = 50, nullable = false)
    private String password;
    /**
     * Atributo UserName
     */
    @Column(name = "name", length = 80, nullable = false)
    private String name;
}
