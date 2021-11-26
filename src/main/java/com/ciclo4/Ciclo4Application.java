package com.ciclo4;

import com.ciclo4.repository.GadgetRepository;
import com.ciclo4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ciclo4Application implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GadgetRepository gadgetRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ciclo4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        gadgetRepository.deleteAll();
    }

}