package com.johyeonjung.blogfeed.controller;

import com.johyeonjung.blogfeed.dto.request.CreatePostCommentReqDto;
import com.johyeonjung.blogfeed.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> createComments(@PathVariable Long postId, @RequestBody CreatePostCommentReqDto dto) {
        commentService.createComment(postId, dto);
        return ResponseEntity.ok("댓글 작성 완료");
    }

    @GetMapping
    public ResponseEntity<?> getComments(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getComments(postId));
    }
}