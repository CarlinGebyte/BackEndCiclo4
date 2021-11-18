package com.ciclo4.service;

import com.ciclo4.model.User;
import com.ciclo4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApi {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public User newUser(User user){
        return userRepository.newUser(user);
    }

    public boolean verifyEmail(String email){
        List<User> users = userRepository.getAll();
        boolean flag = false;
        for (User user : users){
            if (email.equals(user.getEmail())){
                 flag = true;
            }
        }
        return flag;
    }

    public User byEmailPass(String email, String pass){
        List<User> users = userRepository.getAll();
        User notExist = new User(null, email, pass, "NO DEFINIDO");
        for (User user : users){
            if (email.equals(user.getEmail()) && pass.equals(user.getPassword())){
                return user;
            }
        }
        return notExist;
    }
}
