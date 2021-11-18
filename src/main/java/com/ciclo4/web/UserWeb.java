package com.ciclo4.web;

import com.ciclo4.model.User;
import com.ciclo4.service.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/user/")
public class UserWeb {
    @Autowired
    private UserApi userApi;

    @GetMapping("all")
    public List<User> getAll(){
        return userApi.getAll();
    }

    @PostMapping("new")
    public User newUser(@RequestBody User user){
        return userApi.newUser(user);
    }

    @GetMapping("{correoElectrónico}")
    public boolean byEmail(@PathVariable("correoElectrónico") String email){
        return userApi.verifyEmail(email);
    }

    @GetMapping("{email}/{pass}")
    public User byEmailPass(@PathVariable("email") String email, @PathVariable("pass") String pass){
        return userApi.byEmailPass(email, pass);
    }
}
