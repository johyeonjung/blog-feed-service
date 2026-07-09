package com.johyeonjung.blogfeed.service;

import com.johyeonjung.blogfeed.entity.Post;
import com.johyeonjung.blogfeed.entity.PostLike;
import com.johyeonjung.blogfeed.mapper.PostLikeMapper;
import com.johyeonjung.blogfeed.mapper.PostMapper;
import com.johyeonjung.blogfeed.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostLikeService {
    private final PostLikeMapper postLikeMapper;

    public String likePost(Long postId) {
        Long userId = PrincipalUser.getAuthenticatedPrincipalUser().getUser().getUserId();

        //좋아요 중복 확인
        int exists = postLikeMapper.exists(postId,userId);

        if (exists > 0) {
            return "이미 좋아요한 게시글입니다";
        }
        PostLike postLike = PostLike.builder()
                .postId(postId.intValue())
                .userId(userId.intValue())
                .build();

        postLikeMapper.insert(postLike);

        return "좋아요 완료";
    }

    public String unlikePost(Long postId) {
        Long userId = PrincipalUser.getAuthenticatedPrincipalUser().getUser().getUserId();
        int result = postLikeMapper.delete(postId,userId);

        if (result == 0) {
            return "취소할 좋아요가 없습니다";
        }

        return "좋아요 삭제 완료";

    }

}
