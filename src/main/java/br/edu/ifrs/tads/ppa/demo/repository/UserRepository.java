package br.edu.ifrs.tads.ppa.demo.repository;

import br.edu.ifrs.tads.ppa.demo.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface UserRepository extends ListCrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByHandle(String handle);

    boolean existsByHandle(String handle);
}