package com.ciclo4.repository;

import com.ciclo4.model.User;
import com.ciclo4.repository.crud.UserCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CarlinGebyte
 */
@Repository
public class UserRepository {
    /**
     * Atributo Crud de la BD
     */
    @Autowired
    private UserCrud userCrud;

    /**
     * Método para obtener todos los usuarios
     * @return
     */
    public List<User> getAll(){
        return (List<User>) userCrud.findAll();
    }

    /**
     * Método para crear usuarios
     * @param user
     * @return
     */
    public User newUser(User user){
        return userCrud.save(user);
    }
}
