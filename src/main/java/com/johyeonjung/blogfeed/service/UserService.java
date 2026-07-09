package com.johyeonjung.blogfeed.service;

import com.johyeonjung.blogfeed.dto.request.LoginReqDto;
import com.johyeonjung.blogfeed.dto.request.SignupReqDto;
import com.johyeonjung.blogfeed.dto.response.UserProfileResponse;
import com.johyeonjung.blogfeed.entity.User;
import com.johyeonjung.blogfeed.jwt.JwtTokenProvider;
import com.johyeonjung.blogfeed.mapper.UserMapper;
import com.johyeonjung.blogfeed.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void signup(SignupReqDto dto) {

        if (userMapper.findByEmail(dto.getEmail()) != null ) {
            throw new RuntimeException("이미 사용중인 이메일입니다.");
        }

        if (userMapper.findByInstagramId(dto.getInstagramId()) != null) {
            throw new RuntimeException(("이미 사용중인 아이디입니다"));
        }

        if (dto.getPassword().equals( dto.getConfirmPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }

        User user = User.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .provider("LOCAL")
                .role("ROLE_USER")
                .nickname(dto.getNickname())
                .instagramId(dto.getInstagramId())
                .name(dto.getName())
                .gender(dto.getGender())
                .birthDate(dto.getBirthDate())
                .statusMessage(dto.getStatusMessage())
                .build();

        userMapper.insert(user);

    }

    public String login(LoginReqDto dto) {

        User user = userMapper.findByEmail(dto.getEmail());

        if(user == null) {
            throw new RuntimeException("이메일이 일치하지 않습니다");
        }
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }
        return jwtTokenProvider.createAccessToken(user);
    }



    public UserProfileResponse getProfile(String instagramId) {

        User user = userMapper.findByInstagramId(instagramId);

        if (user == null) {
            throw new RuntimeException("존재하지 않는 사용자 입니다");
        }
        Long loginUserId = PrincipalUser.getAuthenticatedPrincipalUser().getUser().getUserId();



        return UserProfileResponse.builder()
                .userId(user.getUserId())
                .instagramId(user.getInstagramId())
                .profileImageUrl(user.getProfileImageUrl())
                .name(user.getName())

                .statusMessage(user.getStatusMessage())
                .followerCount(userMapper.countFollowers(user.getUserId()))
                .postCount(userMapper.countPosts(user.getUserId()))
                .following(userMapper.isFollowing(loginUserId,user.getUserId()) > 0)
                .build();
    }
}
