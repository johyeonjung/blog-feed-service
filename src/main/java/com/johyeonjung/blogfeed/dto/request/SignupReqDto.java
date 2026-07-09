package com.johyeonjung.blogfeed.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SignupReqDto {
    private String email;
    private String password;
    private String confirmPassword;
    private String nickname;
    private String instagramId;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private String statusMessage;
}
