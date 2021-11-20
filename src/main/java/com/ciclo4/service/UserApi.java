package com.ciclo4.service;

import com.ciclo4.model.User;
import com.ciclo4.repository.crud.UserCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CarlinGebyte
 */
@Service
public class UserApi {
    /**
     * Atributo userRepository
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
     * Método para crear un usuario
     * @param user
     * @return
     */
    public User newUser(User user){
        List<User> users = (List<User>) userCrud.findAll();
        if (users.size() == 0){
            return userCrud.save(user);
        }else if (verifyEmail(user.getEmail()) == false) {
            return userCrud.save(user);
        }
        return user;
    }

    /**
     * Método para verificar si existe un usuario con el Email ingresado
     * @param email
     * @return
     */
    public boolean verifyEmail(String email){
        List<User> users = (List<User>) userCrud.findAll();
        boolean flag = false;
        for (User user : users){
            if (email.equals(user.getEmail())){
                 flag = true;
            }
        }
        return flag;
    }

    /**
     * Método para verificar si existe un usuario, Email y Contraseña
     * @param email
     * @param pass
     * @return
     */
    public User byEmailPass(String email, String pass){
        List<User> users = (List<User>) userCrud.findAll();
        User notExist = new User(null, email, pass, "NO DEFINIDO");
        for (User user : users){
            if (email.equals(user.getEmail()) && pass.equals(user.getPassword())){
                return user;
            }
        }
        return notExist;
    }
}
