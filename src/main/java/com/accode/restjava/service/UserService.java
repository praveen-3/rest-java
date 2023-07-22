package com.accode.restjava.service;

import com.accode.restjava.model.Device;
import com.accode.restjava.model.User;
import com.accode.restjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(()-> new IllegalArgumentException("User not found"));
        if(existingUser!=null) {
            if(user.getEmail()!=null) {
                existingUser.setEmail(user.getEmail());
            }
            if(user.getName()!=null) {
                existingUser.setName(user.getName());
            }
            if(user.getMobile()!=null) {
                existingUser.setMobile(user.getMobile());
            }
            if(user.getImage()!=null) {
                existingUser.setImage(user.getImage());
            }
            if(user.getPassword()!=null) {
                existingUser.setPassword(user.getPassword());
            }
            userRepository.save(existingUser);
        }
        return existingUser;
    }
}
