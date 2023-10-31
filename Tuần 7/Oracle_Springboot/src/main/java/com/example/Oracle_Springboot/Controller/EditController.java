package com.example.Oracle_Springboot.Controller;

import com.example.Oracle_Springboot.Model.User;
import com.example.Oracle_Springboot.Repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditController {
    @Autowired
    private UserDAO dao;

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") int id, Model model){
        User u = dao.getUserById(id);
        model.addAttribute("user",u);
        return "edit";
    }

    @PostMapping("/edit/update")
    public String updateUser(User user){
        dao.updateUser(user);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String removeUser(@PathVariable("id") int id){
        dao.removeUserById(id);
        return "redirect:/home";
    }
}