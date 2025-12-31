package com.wallet.user_service.service;

import com.wallet.user_service.model.User;
import com.wallet.user_service.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getMyProfile(Authentication authentication) {
        return repository.findByUsername(authentication.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
