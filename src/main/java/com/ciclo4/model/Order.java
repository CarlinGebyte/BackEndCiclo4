package com.ciclo4.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

/**
 * @author CarlinGebyte
 */
@Document(collection = "orders")
@Data
@Builder
public class Order {
    /**
     * Atributo pendiente
     */
    private static String PENDING = "Pendiente";
    /**
     * Atributo Aprovada
     */
    private static String APPROVED = "Aprobada";
    /**
     * Atributo Rechazada
     */
    private static String REJECTED = "Rechazada";

    /**
     * Atributo Id
     */
    @Id
    @NotNull
    private Integer id;

    /**
     * Atributo fecha de registro
     */
    @NotNull
    private Date registerDay;

    /**
     * Atributo estado
     */
    @NotNull
    @NotBlank
    private String status = this.PENDING;

    /**
     * Atrivbuto asesor
     */
    @NotNull
    private User salesMan;

    /**
     * Atributo productos
     */
    @NotNull
    private Map<String, Gadget> products;

    /**
     * Atributo cantidad
     */
    @NotNull
    private Map<String, Integer> quantities;
}
