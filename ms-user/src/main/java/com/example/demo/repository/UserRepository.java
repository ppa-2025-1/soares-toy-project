package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.model.entity.Users;

public interface UserRepository extends BaseRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);
    // This interface will automatically provide CRUD operations for the User entity
    // You can add custom query methods here if needed

    Optional<Users> findByHandle(String handle);

    @SuppressWarnings("null")
    Optional<Users> findById(Integer id);

    boolean existsByHandle(String handle);

}
