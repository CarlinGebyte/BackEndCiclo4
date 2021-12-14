package com.ciclo4.controller;

import com.ciclo4.model.User;
import com.ciclo4.model.dto.UserDTO;
import com.ciclo4.model.request.NewUserRequest;
import com.ciclo4.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
     *
     * @param userServiceImpl
     */
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    /**
     * Método para obtener todos los usuarios
     *
     * @return
     */
    @GetMapping("all")
    public List<UserDTO> getAll() {
        return userServiceImpl.getAll();
    }

    /**
     * Método para obtener un usuerio por Id
     *
     * @param idUser
     * @return
     */
    @GetMapping("{id}")
    public Optional<User> getUser(@PathVariable("id") Integer idUser) {
        return userServiceImpl.getUser(idUser);
    }

    /**
     * Método para crear un usuario
     *
     * @param request
     * @return
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO newUser(@RequestBody NewUserRequest request) {
        return userServiceImpl.newUser(request);
    }

    /**
     * Método para verificar si existe un usuario con el Email ingresado
     *
     * @param email
     * @return
     */
    @GetMapping("emailexist/{correoElectrónico}")
    public boolean byEmail(@PathVariable("correoElectrónico") String email) {
        return userServiceImpl.verifyEmail(email);
    }

    /**
     * Método para verificar si existe un usuario, Email y Contraseña
     *
     * @param email
     * @param pass
     * @return
     */
    @GetMapping("{email}/{pass}")
    public UserDTO byEmailPass(@PathVariable("email") String email, @PathVariable("pass") String pass) {
        return userServiceImpl.byEmailPass(email, pass);
    }

    /**
     * Método para actualizar un usuario
     *
     * @param request
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody NewUserRequest request) {
        return userServiceImpl.editUser(request);
    }

    /**
     * Método para eliminar un usuario
     *
     * @param idUser
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer idUser) {
        userServiceImpl.deleteUser(idUser);
    }

    /**
     * Método para listar usuarios cuyo mes de cumpleaños sea el ingresado
     *
     * @param month
     * @return
     */
    @GetMapping("birthday/{month}")
    public List<User> userByMonth(@PathVariable("month") String month) {
        return userServiceImpl.userByMonth(month);
    }
}
