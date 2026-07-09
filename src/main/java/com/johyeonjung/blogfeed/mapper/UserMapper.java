package com.johyeonjung.blogfeed.mapper;

import com.johyeonjung.blogfeed.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

@Mapper
public interface UserMapper {
    int insert(User user);

    User findByInstagramId(@Param("instagramId") String instagramId);
    User findByEmail(String email);
    User findByUserId(@Param("userId") Long userId);
    int countFollowers(Long userId);
    int countPosts(Long userId);
    int isFollowing(Long loginUserId, Long profileUserId);



}
