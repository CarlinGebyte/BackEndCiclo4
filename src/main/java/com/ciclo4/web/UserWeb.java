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
    /**
     * Atributo UserApi
     */
    @Autowired
    private UserApi userApi;

    /**
     * Método para obtener todos los usuarios
     * @return
     */
    @GetMapping("all")
    public List<User> getAll(){
        return userApi.getAll();
    }

    /**
     * Método para crear un usuario
     * @param user
     * @return
     */
    @PostMapping("new")
    public User newUser(@RequestBody User user){
        return userApi.newUser(user);
    }

    /**
     * Método para verificar si existe un usuario con el Email ingresado
     * @param email
     * @return
     */
    @GetMapping("{correoElectrónico}")
    public boolean byEmail(@PathVariable("correoElectrónico") String email){
        return userApi.verifyEmail(email);
    }

    /**
     * Método para verificar si existe un usuario, Email y Contraseña
     * @param email
     * @param pass
     * @return
     */
    @GetMapping("{email}/{pass}")
    public User byEmailPass(@PathVariable("email") String email, @PathVariable("pass") String pass){
        return userApi.byEmailPass(email, pass);
    }
}
