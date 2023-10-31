package com.example.Oracle_Springboot.Controller;

import com.example.Oracle_Springboot.Model.User;
import com.example.Oracle_Springboot.Repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserDAO dao;

    @GetMapping("/")
    public String loginPage(Model model){
        return "index";
    }

    @PostMapping("/login")
    public String checkLogin(@RequestParam("username") String name, @RequestParam("password") String pass){
        for(User u : dao.listAll()){
            if(u.getUsername().equals(name) && u.getPassword().equals(pass)){
                return "redirect:/home";
            }
        }
        return "redirect:/";
    }
}
