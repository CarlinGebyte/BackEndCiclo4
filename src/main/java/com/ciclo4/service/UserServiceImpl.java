package com.ciclo4.service;

import com.ciclo4.exception.BaseCustomException;
import com.ciclo4.model.User;
import com.ciclo4.model.dto.UserDTO;
import com.ciclo4.model.request.NewUserRequest;
import com.ciclo4.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CarlinGebyte
 */
@Service
public class UserServiceImpl {

    /**
     * Atributo Repositorio
     */
    private final UserRepository userRepository;

    /**
     * Constructor
     * @param userRepository
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Método para obtener todos los usuarios
     *
     * @return
     */
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * Método para crear un usuario
     *
     * @param user
     * @return
     */
    public UserDTO newUser(NewUserRequest user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(e -> {
                    throw new BaseCustomException("El correo ya existe", HttpStatus.BAD_REQUEST.value());
                });

        User savedUser = userRepository.save(
                User.builder()
                        .email(user.getEmail())
                        .name(user.getName())
                        .password(user.getPassword())
                        .build()
        );

        return UserDTO.builder()
                .name(savedUser.getName())
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .build();
    }

    /**
     * Método para verificar si existe un usuario con el Email ingresado
     *
     * @param email
     * @return
     */
    public boolean verifyEmail(String email) {
        List<User> users = userRepository.findAll();
        boolean flag = false;
        for (User user : users) {
            if (email.equals(user.getEmail())) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Método para verificar si existe un usuario, Email y Contraseña
     *
     * @param email
     * @param pass
     * @return
     */
    public User byEmailPass(String email, String pass) {
        List<User> users = userRepository.findAll();
        User notExist = new User(null, email, pass, "NO DEFINIDO");
        for (User user : users) {
            if (email.equals(user.getEmail()) && pass.equals(user.getPassword())) {
                return user;
            }
        }
        return notExist;
    }
}
