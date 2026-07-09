package com.johyeonjung.blogfeed.controller;

import com.johyeonjung.blogfeed.dto.request.LoginReqDto;
import com.johyeonjung.blogfeed.dto.request.SignupReqDto;
import com.johyeonjung.blogfeed.service.UserService;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("api/auth")
@RestController
public class AuthController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupReqDto dto) {
        userService.signup(dto);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginReqDto dto) {
        String accessToken = userService.login(dto);
        return ResponseEntity.ok(accessToken);
    }
}
