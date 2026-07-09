package com.johyeonjung.blogfeed.mapper;

import com.johyeonjung.blogfeed.entity.PostLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostLikeMapper {
    int insert(PostLike postLike);
    int exists(@Param("postId") Long postId,
               @Param("userId") Long userId);
    int delete(@Param("postId") Long postId,
               @Param("userId") Long userId);

}
