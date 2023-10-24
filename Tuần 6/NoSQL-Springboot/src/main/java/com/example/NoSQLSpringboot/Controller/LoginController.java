package com.example.NoSQLSpringboot.Controller;

import com.example.NoSQLSpringboot.Model.User;
import com.example.NoSQLSpringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String login(){
        return "index";
    }

    @PostMapping("/login")
    public String checkLogin(@RequestParam("username") String name, @RequestParam("password") String pass){
        for(User u : service.listAll()){
            if(u.getUsername().equals(name) && u.getPassword().equals(pass)){
                return "redirect:/home";
            }
        }
        return "index";
    }
}
