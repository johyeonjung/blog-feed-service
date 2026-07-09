package com.johyeonjung.blogfeed.mapper;

import com.johyeonjung.blogfeed.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;

@Mapper
public interface UserMapper {
    int insert(User user);


    User findByUserId(int userId);
    User findByOauth2Id(String oauth2Id);
    User findByNickname(String nickname);
    String createNickname();

    User findByInstagramId(String instgramId);
    User findByEmail(String email);

    int countFollowers(Long userId);
    int countFollowings(Long userId);
    int countPosts(Long userId);
    int isFollowing(Long loginUserId, Long profileUserId);



}
