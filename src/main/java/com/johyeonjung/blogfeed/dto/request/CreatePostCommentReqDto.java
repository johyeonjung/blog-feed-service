package com.johyeonjung.blogfeed.dto.request;

import lombok.Data;

@Data
public class CreatePostCommentReqDto {
    private Long parentCommentId;
    private Long parentUserId;
    private String content;
}