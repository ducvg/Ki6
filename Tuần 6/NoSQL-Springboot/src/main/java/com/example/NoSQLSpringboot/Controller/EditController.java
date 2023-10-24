package com.example.NoSQLSpringboot.Controller;

import com.example.NoSQLSpringboot.Model.User;
import com.example.NoSQLSpringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditController {
    @Autowired
    private UserService service;

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") int id, Model model){
        User u = service.getUserById(id);
        model.addAttribute("user",u);
        return "edit";
    }

    @PostMapping("/edit/update")
    public String updateUser(User user){
        service.updateUser(user);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String removeUser(@PathVariable("id") int id){
        service.removeUserById(id);
        return "redirect:/home";
    }
}