package com.example.ExpenseTracker.controller;

import com.example.ExpenseTracker.Service.UserService;
import com.example.ExpenseTracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        userService.registeruser(user);
        return "User registered Successfully";
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password){
    if(userService.validateUserLogin(username,password)){
        return "user logged in";
    }
    return "Invalid username or password";
    }
}
