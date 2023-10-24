package com.example.NoSQLSpringboot.Controller;

import com.example.NoSQLSpringboot.Model.User;
import com.example.NoSQLSpringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired private UserService service;

    @GetMapping("/register")
    public String defaultPage(){
        return "register";
    }

    @PostMapping("/register/create")
    public String userRegister(Model model, @RequestParam("username") String name,
                               @RequestParam("hobby") String hobby,
                               @RequestParam("password") String pass,
                               @RequestParam("repassword") String repass){
        if(!pass.equals(repass)){
            model.addAttribute("message","Incorrect password");
            return "register";
        }
        for (User u : service.listAll()){
            if(u.getUsername().equals(name)){
                model.addAttribute("message","Account existed!");
                return "register";
            }
        }
        service.addUser(new User(name, pass, hobby));
        return "redirect:/";
    }
}
