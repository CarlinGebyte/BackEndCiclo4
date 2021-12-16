package com.ciclo4.repository;

import com.ciclo4.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author CarlinGebyte
 */
public interface GadgetRepository extends MongoRepository<Gadget, Integer> {

    /**
     * Listar gadgets que tengan un precio menor o igual al ingresado
     *
     * @param price
     * @return
     */
    List<Gadget> findGadgetByPriceIsLessThanEqual(Double price);

    /**
     * Listar gadgets por un String enviado, si se encuentra en su descripción
     *
     * @param description
     * @return
     */

    List<Gadget> findGadgetByDescriptionRegex(String description);
}
