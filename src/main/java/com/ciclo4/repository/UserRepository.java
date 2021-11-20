package com.ciclo4.repository;

import com.ciclo4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author CarlinGebyte
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
