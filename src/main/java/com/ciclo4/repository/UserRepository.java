package com.ciclo4.repository;

import com.ciclo4.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author CarlinGebyte
 */
public interface UserRepository extends MongoRepository<User, Integer> {

    /**
     * Método para encontrar por email
     *
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);

    /**
     * Método para listar usuarios cuyo mes de cumpleaños sea el ingresado
     *
     * @param month
     * @return
     */
    List<User> findByMonthBirthtDay(String month);
}
