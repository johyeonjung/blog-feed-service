package com.johyeonjung.blogfeed.dto.request;

import lombok.Data;

@Data
public class CreatePostCommentReqDto {
    private int parentCommentId;
    private int parentUserId;
    private String content;
}