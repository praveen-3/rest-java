package com.accode.restjava.controller;

import com.accode.restjava.model.User;
import com.accode.restjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam (name = "userId") long userId) {
        User userResponse = userService.getUserById(userId);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user-by-email")
    public ResponseEntity<User> getUserByEmail(@RequestParam (name = "email") String email) {
        User userResponse = userService.getUserByEmail(email);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }

    @PatchMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User userResponse = userService.updateUser(user);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
}
