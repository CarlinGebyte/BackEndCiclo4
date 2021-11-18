package com.ciclo4.repository.crud;

import com.ciclo4.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrud extends CrudRepository<User, Integer> {
}
