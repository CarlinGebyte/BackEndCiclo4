package com.ciclo4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * @author CarlinGebyte
 */
@Data // Getter y Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "gadgets")
public class Gadget {
    @Id
    private Integer id;

    private String brand;

    private String category;

    private String name;

    private String description;

    private double price;

    private boolean availability = true;

    private int quantity;

    private String photography;
}
