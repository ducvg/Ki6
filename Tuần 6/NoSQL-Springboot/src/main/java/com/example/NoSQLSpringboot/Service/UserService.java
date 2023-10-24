package com.example.NoSQLSpringboot.Service;

import com.example.NoSQLSpringboot.Model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    public List<User> listAll();
    public void addUser(User u);
    public User getUserById(int id);
    public void updateUser(User user);
    public void removeUserById(int id);
}
