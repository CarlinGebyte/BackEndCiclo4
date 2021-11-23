package com.ciclo4.repository;

import com.ciclo4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * @author CarlinGebyte
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Método para encontrar por email
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);
}
