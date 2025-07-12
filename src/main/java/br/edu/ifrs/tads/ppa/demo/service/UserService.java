package br.edu.ifrs.tads.ppa.demo.service;

import br.edu.ifrs.tads.ppa.demo.model.NewUser;
import br.edu.ifrs.tads.ppa.demo.model.User;

import java.util.List;

public interface UserService {
    void createUser(NewUser newUser);
    List<User> getAllUsers();
}