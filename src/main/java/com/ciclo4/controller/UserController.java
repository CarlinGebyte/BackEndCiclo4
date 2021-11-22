package com.ciclo4.controller;

import com.ciclo4.model.User;
import com.ciclo4.model.dto.UserDTO;
import com.ciclo4.model.request.NewUserRequest;
import com.ciclo4.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author CarlinGebyte
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/user/")
public class UserController {
    /**
     * Atributo Service
     */
    private final UserServiceImpl userServiceImpl;

    /**
     * Método constructor
     * @param userServiceImpl
     */
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    /**
     * Método para obtener todos los usuarios
     * @return
     */
    @GetMapping("all")
    public List<UserDTO> getAll(){
        return userServiceImpl.getAll();
    }

    /**
     * Método para crear un usuario
     * @param request
     * @return
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO newUser(@RequestBody NewUserRequest request){
        return userServiceImpl.newUser(request);
    }

    /**
     * Método para verificar si existe un usuario con el Email ingresado
     * @param email
     * @return
     */
    @GetMapping("{correoElectrónico}")
    public boolean byEmail(@PathVariable("correoElectrónico") String email){
        return userServiceImpl.verifyEmail(email);
    }

    /**
     * Método para verificar si existe un usuario, Email y Contraseña
     * @param email
     * @param pass
     * @return
     */
    @GetMapping("{email}/{pass}")
    public User byEmailPass(@PathVariable("email") String email, @PathVariable("pass") String pass){
        return userServiceImpl.byEmailPass(email, pass);
    }
}
