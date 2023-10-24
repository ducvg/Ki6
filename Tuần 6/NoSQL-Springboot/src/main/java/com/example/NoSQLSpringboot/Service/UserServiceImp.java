package com.example.NoSQLSpringboot.Service;

import com.example.NoSQLSpringboot.Model.User;
import com.example.NoSQLSpringboot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Sequence;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository repo;
    @Autowired
    private IdIncrementService inc;

    @Override
    public List<User> listAll() {
        return repo.findAll();
    }

    @Override
    public void addUser(User u) {
        u.setId(inc.getSequenceNumber(User.ID_COUNTER));
        repo.save(u);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> user = repo.findById(id);
        if(user.isPresent()) return user.get();
        else return null;
    }

    @Override
    public void updateUser(User user) {
        repo.save(user);
    }

    @Override
    public void removeUserById(int id) {
        repo.deleteById(id);
    }
}
