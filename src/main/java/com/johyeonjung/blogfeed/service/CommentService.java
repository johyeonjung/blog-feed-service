package com.johyeonjung.blogfeed.service;


import com.johyeonjung.blogfeed.dto.request.CreatePostCommentReqDto;
import com.johyeonjung.blogfeed.entity.Comment;
import com.johyeonjung.blogfeed.entity.CustomComment;
import com.johyeonjung.blogfeed.entity.User;
import com.johyeonjung.blogfeed.mapper.CommentMapper;
import com.johyeonjung.blogfeed.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper commentMapper;

    public void createComment(int postId, CreatePostCommentReqDto dto) {
        User user = PrincipalUser.getAuthenticatedPrincipalUser().getUser();

        commentMapper.insert(Comment.builder()
                .postId(postId)
                .parentCommentId(dto.getParentCommentId())
                .parentUserId(dto.getParentUserId())
                .userId(user.getUserId())
                .content(dto.getContent())
                .build());
    }

    public List<CustomComment> getComments(int postId) {
        return commentMapper.findAllCommentByPostId(postId);
    }
}