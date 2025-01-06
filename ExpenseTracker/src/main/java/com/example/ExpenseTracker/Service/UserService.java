package com.example.ExpenseTracker.Service;

import com.example.ExpenseTracker.model.User;
import com.example.ExpenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private User user;

    public void registeruser(User user)
    {
        userRepository.save(user);
    }
    public boolean validateUserLogin(String username, String password) {
        String FindUsername = String.valueOf(userRepository.findByUsername(username));
        if (FindUsername!= null) {
            return password.equals(user.getPassword());
        }
        return false;
    }
}