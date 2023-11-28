package com.example.demo.Config;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    private UserService userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.getUserbyUsername(username);
        if(u != null){
            return new UserInfoDetails(u);
        }
        throw new UsernameNotFoundException("username not available");
    }

}
