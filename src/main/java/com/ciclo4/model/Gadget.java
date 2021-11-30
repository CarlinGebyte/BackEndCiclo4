package com.ciclo4.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author CarlinGebyte
 */
@Data // Getter y Setter
@Builder
@Document(collection = "gadgets")
public class Gadget {
    /**
     * Atributo Id
     */
    @Id
    private Integer id;
    /**
     * Atributo Brand
     */
    @NotNull
    @NotBlank
    private String brand;
    /**
     * Atributo Category
     */
    @NotNull
    @NotBlank
    private String category;
    /**
     * Atributo Name
     */
    @NotNull
    @NotBlank
    private String name;
    /**
     * Atributo Description
     */
    @NotNull
    @NotBlank
    private String description;
    /**
     * Atributo Price
     */
    @NotNull
    @NotBlank
    private Double price;
    /**
     * Atributo availability
     */
    @NotNull
    @NotBlank
    private Boolean availability = true;
    /**
     * Atributo quantity
     */
    @NotNull
    @NotBlank
    private Integer quantity;
    /**
     * Atributo photography
     */
    @NotNull
    @NotBlank
    private String photography;
}
