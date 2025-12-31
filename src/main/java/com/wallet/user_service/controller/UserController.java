package com.wallet.user_service.controller;

import com.wallet.user_service.model.User;
import com.wallet.user_service.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // USER -> view own profile
    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public User myProfile(Authentication authentication) {
        return userService.getMyProfile(authentication);
    }

    // ADMIN -> view all users
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> allUsers() {
        return userService.getAllUsers();
    }
}
