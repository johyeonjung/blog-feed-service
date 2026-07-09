package com.johyeonjung.blogfeed.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String oauth2Id;
    private String email;
    private String password;
    private String provider;
    private String role;
    private String nickname;
    private String instagramId;
    private String name;
    private String profileImageUrl;
    private String gender;
    private LocalDate birthDate;
    private String statusMessage;
}
