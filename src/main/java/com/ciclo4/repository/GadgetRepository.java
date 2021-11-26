package com.ciclo4.repository;

import com.ciclo4.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author CarlinGebyte
 */
@Repository
public interface GadgetRepository extends MongoRepository<Gadget, Integer> {
}
