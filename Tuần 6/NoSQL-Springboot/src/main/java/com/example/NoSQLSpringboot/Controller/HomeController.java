package com.example.NoSQLSpringboot.Controller;

import com.example.NoSQLSpringboot.Model.User;
import com.example.NoSQLSpringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired private UserService userServiceImpl;

    @GetMapping("/home")
    public String userList(Model model){
        List<User> userList = userServiceImpl.listAll();
        model.addAttribute("userList",userList);
        return "home";
    }
}