package com.ciclo4.service;

import com.ciclo4.model.User;
import com.ciclo4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CarlinGebyte
 */
@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Método para obtener todos los usuarios
     * @return
     */
    public List<User> getAll(){
        return userRepository.findAll();
    }

    /**
     * Método para crear un usuario
     * @param user
     * @return
     */
    public User newUser(User user){
        return userRepository.save(user);
    }

    /**
     * Método para verificar si existe un usuario con el Email ingresado
     * @param email
     * @return
     */
    public boolean verifyEmail(String email){
        List<User> users = userRepository.findAll();
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
        List<User> users = userRepository.findAll();
        User notExist = new User(null, email, pass, "NO DEFINIDO");
        for (User user : users){
            if (email.equals(user.getEmail()) && pass.equals(user.getPassword())){
                return user;
            }
        }
        return notExist;
    }
}
