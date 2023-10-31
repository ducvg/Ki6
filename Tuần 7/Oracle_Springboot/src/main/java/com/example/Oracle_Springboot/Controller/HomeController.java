package com.example.Oracle_Springboot.Controller;

import com.example.Oracle_Springboot.Model.User;
import com.example.Oracle_Springboot.Repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired private UserDAO dao;

    @GetMapping("/home")
    public String userList(Model model){
        List<User> userList = dao.listAll();
        model.addAttribute("userList",userList);
        return "home";
    }
}