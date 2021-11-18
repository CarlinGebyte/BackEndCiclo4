package com.ciclo4.repository.crud;

import com.ciclo4.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author CarlinGebyte
 */
public interface UserCrud extends CrudRepository<User, Integer> {
}
