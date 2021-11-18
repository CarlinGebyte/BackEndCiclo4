package com.ciclo4.repository;

import com.ciclo4.model.User;
import com.ciclo4.repository.crud.UserCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    private UserCrud userCrud;

    public List<User> getAll(){
        return (List<User>) userCrud.findAll();
    }

    public User newUser(User user){
        return userCrud.save(user);
    }
}
