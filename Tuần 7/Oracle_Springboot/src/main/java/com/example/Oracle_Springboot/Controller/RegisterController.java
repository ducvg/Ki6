package com.example.Oracle_Springboot.Controller;

import com.example.Oracle_Springboot.Model.User;
import com.example.Oracle_Springboot.Repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired private UserDAO dao;

    @GetMapping("/register")
    public String defaultPage(Model model){
        User u = new User();
        model.addAttribute("user",u);
        return "register";
    }

    @PostMapping("/register/create")
    public String userRegister(Model model, @ModelAttribute("user") User user,
                               @RequestParam("repassword") String repass){
        if(!user.getPassword().equals(repass)){
            model.addAttribute("message","Incorrect password");
            return "register";
        }
        for (User u : dao.listAll()){
            if(u.getUsername().equals(user.getUsername())){
                model.addAttribute("message","Account existed!");
                return "register";
            }
        }
        dao.addUser(user);
        return "redirect:/";
    }
}