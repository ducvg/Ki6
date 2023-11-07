package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EditController {
    @Autowired private UserServiceImpl userServiceImpl;

    @PutMapping("/edit/update/{id}")
    public String updateUser(@PathVariable("id") Long id,@RequestBody User user){
        User u = userServiceImpl.getUserById(id);
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setHobby(user.getHobby());
        userServiceImpl.updateUser(u);
        return "User updated !";
    }

    @DeleteMapping("/delete/{id}")
    public String removeUser(@PathVariable("id") Long id){
        userServiceImpl.removeUserById(id);
        return "User removed !";
    }
}
