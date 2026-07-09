package com.johyeonjung.blogfeed.mapper;

import com.johyeonjung.blogfeed.dto.request.UpdatePostReqDto;
import com.johyeonjung.blogfeed.dto.response.PostResponse;
import com.johyeonjung.blogfeed.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    //게시물 저장
    int insert(Post post);

    //게시물 1개 조회
    PostResponse getPost(@Param("postId") Long postId,
                         @Param("userId") Long userId);

    //아이디 기준 해당 유저 게시글 목록 조회
    List<PostResponse> getUserPosts(@Param("instagramId") String instagramId,
                                    @Param("userId") Long userId);

    //로그인한 사용자 피드 조회
    List<PostResponse> getFeeds(
            @Param("startIndex") int startIndex,
            @Param("size") int size,
            @Param("userId") Long userId);
    //페이지네이션용 전체 개수
    int getTotalCount(@Param("userId") Long userId);

    //게시글 수정
    int updatePost(@Param("postId") Long postId,
                    @Param("dto") UpdatePostReqDto dto);

    int deletePost(@Param("postId") Long postId);

}
