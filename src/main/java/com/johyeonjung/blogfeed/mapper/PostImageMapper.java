package com.johyeonjung.blogfeed.mapper;

import com.johyeonjung.blogfeed.entity.PostImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostImageMapper {
    int insert(PostImage postImage);
    List<String> getImageUrlByPostId(@Param("postId") Long postId);
}
