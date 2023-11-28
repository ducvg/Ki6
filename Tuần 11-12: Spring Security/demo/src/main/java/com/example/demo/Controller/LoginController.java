package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired private UserRepo repo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("")
    public String index(){
        System.out.println("what??? ::"+passwordEncoder.encode("123admin"));
        return "index";
    }

    @PostMapping("/login")
    public String checkLogin(@RequestParam("username") String name, @RequestParam("password") String pass){
        for(User u : repo.findAll()){
            if(u.getUsername().equals(name) && u.getPassword().equals(pass)){
                return "redirect:/home";
            }
        }
        return "index";
    }


}
