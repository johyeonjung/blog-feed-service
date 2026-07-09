package com.johyeonjung.blogfeed.controller;


import com.johyeonjung.blogfeed.dto.response.PostResponse;
import com.johyeonjung.blogfeed.entity.User;
import com.johyeonjung.blogfeed.security.PrincipalUser;
import com.johyeonjung.blogfeed.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMe(@AuthenticationPrincipal PrincipalUser principalUser) {
        if (principalUser == null ) {
            return ResponseEntity.status(401).body("로그인이 필요합니다");
        }

        return ResponseEntity.ok(principalUser.getUser());
    }

    @GetMapping("/{instgramId}")
    public ResponseEntity<?> getUserProfile(@PathVariable String instgramId) {
        return ResponseEntity.ok(userService.getProfile(instgramId));
    }



}