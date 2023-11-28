package com.example.demo.Service;

import com.example.demo.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> listAll();
    public void addUser(User u);
    public User getUserById(Integer id);
    public void updateUser(User user);
    public void removeUserById(Integer id);
    public User getUserbyUsername(String username);

}
