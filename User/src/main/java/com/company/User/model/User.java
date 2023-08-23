package com.company.User.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
    @Column(name="name")
    private String name;

    @Id
    @Column(name="email")
    private String email;
    @Column(name = "password")
    private String password;

    public User(){}

    public User(String name,String email,String password){
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
