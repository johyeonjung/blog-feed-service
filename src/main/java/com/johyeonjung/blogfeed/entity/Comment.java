package com.johyeonjung.blogfeed.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long commentId;
    private Long postId;
    private Long parentCommentId;
    private Long parentUserId;
    private Long userId;
    private String content;
    private LocalDateTime createdAt;
}