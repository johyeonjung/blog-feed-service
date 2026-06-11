package com.johyeonjung.blogfeed.service;

import com.johyeonjung.blogfeed.entity.User;
import com.johyeonjung.blogfeed.mapper.UserMapper;
import com.johyeonjung.blogfeed.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public User createUser(Authentication authentication) {
        PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
        User user = principalUser.getUser();
        user.setNickname(createNickname());
        userMapper.insert(user);
        return user;
    }
    public User findUserByOauth2Id(String oauth2Id) {
        return userMapper.findByOauth2Id(oauth2Id);
    }

    public String createNickname() {
        String newNickname = null;
        while (true) {
            newNickname = userMapper.createNickname();
            if (userMapper.findByNickname(newNickname) == null) {
                break;
            }
        }
        return newNickname;
    }
}
