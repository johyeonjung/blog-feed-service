package com.johyeonjung.blogfeed.controller;

import com.johyeonjung.blogfeed.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostLikeController {
    private PostLikeService postLikeService;

    @PostMapping("/{postId}/likes")
    public ResponseEntity<String> likePost(@PathVariable Long postId) {
        return ResponseEntity.ok(postLikeService.likePost(postId));

    }

    @DeleteMapping("/{postId}/likes")
    public ResponseEntity<?> unlikePost(@PathVariable Long postId) {
        postLikeService.unlikePost(postId);
        return ResponseEntity.ok("좋아요 삭제 완료");
    }


}
