package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired private UserRepo repo;

    @PostMapping("/login")
    public String checkLogin(@RequestBody User user){
        for(User u : repo.findAll()){
            if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())){
                return "Login success !";
            }
        }
        return "Invalid user information !";
    }
}
