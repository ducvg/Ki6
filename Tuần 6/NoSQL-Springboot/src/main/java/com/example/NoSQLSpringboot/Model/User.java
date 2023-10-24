package com.example.NoSQLSpringboot.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "User")
public class User {
    @Transient
    public static final String ID_COUNTER = "ID_COUNTER";

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
}
