package com.example.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    private Integer id;

    public Users() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}