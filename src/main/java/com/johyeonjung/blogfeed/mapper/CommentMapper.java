package com.johyeonjung.blogfeed.mapper;

import com.johyeonjung.blogfeed.entity.Comment;
import com.johyeonjung.blogfeed.entity.CustomComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    int insert(Comment comment);
    List<CustomComment> findAllCommentByPostId(@Param("postId") Long postId);
}