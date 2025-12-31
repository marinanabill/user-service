package com.wallet.user_service.controller;

import com.wallet.user_service.model.User;
import com.wallet.user_service.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser(username = "marina", roles = "USER")
    void myProfile_shouldReturn200() throws Exception {

        when(userService.getMyProfile(org.mockito.ArgumentMatchers.any()))
                .thenReturn(new User("marina", 1000.0, User.Role.USER));

        mockMvc.perform(get("/users/me"))
                .andExpect(status().isOk());
    }
}
