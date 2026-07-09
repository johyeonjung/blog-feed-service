package com.johyeonjung.blogfeed.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Long postId;
    private Long userId;
    private String instagramId;
    private String nickname;
    private String profileImageUrl;
    private String visibility;

    private String content;
    private List<String> imageUrls;
    private int likeCount;
    private int commentCount;
    private boolean liked;
    private boolean bookmarked;

    private LocalDateTime createdAt;
}
