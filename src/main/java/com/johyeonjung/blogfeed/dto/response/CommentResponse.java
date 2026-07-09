package com.johyeonjung.blogfeed.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
    private Long commentId;
    private Long userId; //클릭시 조회할 아이디
    private String nickname;
    private String content;
    private String profileImageUrl;

    private int likeCount;

    private LocalDateTime createdAt;



}
