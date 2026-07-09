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

    ResponseEntity<?> findByInstgramId(String instgramId);
}
