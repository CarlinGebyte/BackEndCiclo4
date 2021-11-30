package com.ciclo4.repository;

import com.ciclo4.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author CarlinGebyte
 */
public interface UserRepository extends MongoRepository<User, Integer> {

    /**
     * Método para encontrar por email
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);
}
