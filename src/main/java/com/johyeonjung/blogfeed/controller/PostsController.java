package com.johyeonjung.blogfeed.controller;

import com.johyeonjung.blogfeed.dto.request.CreatePostReqDto;
import com.johyeonjung.blogfeed.dto.request.GetFeedListReqDto;
import com.johyeonjung.blogfeed.dto.request.UpdatePostReqDto;
import com.johyeonjung.blogfeed.dto.response.PaginationRespDto;
import com.johyeonjung.blogfeed.dto.response.PostResponse;
import com.johyeonjung.blogfeed.entity.Post;
import com.johyeonjung.blogfeed.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostsController {

    private final PostService postService;

    //이미지 데이터 포함
    //게시물 작성
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  ResponseEntity<?> createPost(@ModelAttribute CreatePostReqDto dto) {
        System.out.println(dto);
        postService.createPost(dto);
        return ResponseEntity.ok("게시글 작성 완료");
    }
    //특정게시물 하나 조회
    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    //특정 유저 전체 게시글
    @GetMapping("/users/{instagramId}")
    public ResponseEntity<List<PostResponse>> getUserPosts(@PathVariable String instagramId) {
        return ResponseEntity.ok(postService.getUserPosts(instagramId));
    }

    //내가 팔로워하고 있는 사람들의 전체 게시물들, 페이지네이션
    @GetMapping
    public ResponseEntity<PaginationRespDto<PostResponse>> getFeeds(GetFeedListReqDto dto) {
        return ResponseEntity.ok(postService.getFeeds(dto));
    }

    //게시글 수정
    @PutMapping("/{postId}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable Long postId, @RequestBody UpdatePostReqDto dto ) {
        return ResponseEntity.ok(postService.updatePost(postId, dto));
    }

    //게시글 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId ) {
        postService.deletePost(postId);
        return ResponseEntity.ok("게시물 삭제 완료");
    }

}
