package com.johyeonjung.blogfeed.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {
    private Long userId;
    private String instagramId;
    private String nickname;
    private String profileImageUrl;
    private String name;
    private String statusMessage;

    private int followerCount;
    private int followingCount;
    private int postCount;

    private boolean following;
}
