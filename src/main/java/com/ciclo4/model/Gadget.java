package com.ciclo4.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;

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
    private String brand;
    /**
     * Atributo Category
     */
    private String category;
    /**
     * Atributo Name
     */
    private String name;
    /**
     * Atributo Description
     */
    private String description;
    /**
     * Atributo Price
     */
    private Double price;
    /**
     * Atributo availability
     */
    private Boolean availability = true;
    /**
     * Atributo quantity
     */
    private Integer quantity;
    /**
     * Atributo photography
     */
    private String photography;
}
