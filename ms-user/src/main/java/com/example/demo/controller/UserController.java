package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NewUser;
import com.example.demo.model.business.UserBusiness;
import com.example.demo.model.entity.Users;
import com.example.demo.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends AbstractController {

    private final UserRepository userRepository;
    private final UserBusiness userBusiness;

    public UserController(UserRepository userRepository,
                          UserBusiness userBusiness) {
        this.userRepository = userRepository;
        this.userBusiness = userBusiness;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewUser(@Valid @RequestBody NewUser newUser) {

        userBusiness.criarUsuario(newUser);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Users>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Integer id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
