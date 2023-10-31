package com.example.Oracle_Springboot.Model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    private int id;
    private String username;
    private String password;
    private String hobby;

    public User(){}

    public User(int id, String username, String password, String hobby) {
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
        return id+" User: "+username+", hobby: "+hobby;
    }
}
