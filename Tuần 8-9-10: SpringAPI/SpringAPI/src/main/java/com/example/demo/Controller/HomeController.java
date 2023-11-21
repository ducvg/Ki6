package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired private UserServiceImpl userServiceImpl;

    @GetMapping("/list")
    public List<User> userList(Model model){
        return userServiceImpl.listAll();
    }

    @GetMapping("/detail/{id}")
    public User showEdit(@PathVariable("id") Long id){
        return userServiceImpl.getUserById(id);
    }
}
