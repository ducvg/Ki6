package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired private UserRepo repo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public void addUser(User user){
        System.out.println("UserService: adduser: "+user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_user");
        repo.save(user);
    }

    public User getUserById(Integer id){
        Optional<User> user = repo.findById(id);
        if(user.isPresent()) return user.get();
        else return null;
    }

    public void updateUser(User user){
        repo.save(user);
    }

    public void removeUserById(Integer id){
        repo.deleteById(id);
    }

    @Override
    public User getUserbyUsername(String username) {
        return repo.getUserbyUsername(username);
    }
}

