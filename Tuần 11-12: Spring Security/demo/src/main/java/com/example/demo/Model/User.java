package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String hobby;
    private String role;

    public User(){}

    public User(Integer id, String username, String password, String hobby,String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.hobby = hobby;
        this.role = role;
    }

    public User(Integer id, String username, String password, String hobby) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.hobby = hobby;
    }

    public User(String name, String pass, String hobby) {
        username = name;
        password = pass;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
