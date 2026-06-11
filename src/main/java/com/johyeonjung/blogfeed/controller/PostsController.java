package com.johyeonjung.blogfeed.controller;

import com.johyeonjung.blogfeed.dto.request.CreatePostReqDto;
import com.johyeonjung.blogfeed.dto.request.GetFeedListReqDto;
import com.johyeonjung.blogfeed.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostsController {

    private final PostService postService;

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createPost(@ModelAttribute CreatePostReqDto dto) {
        System.out.println(dto);
        postService.createPost(dto);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/feeds")
    public ResponseEntity<?> getFeedList(GetFeedListReqDto dto) {
        return ResponseEntity.ok(postService.getFeeds(dto));
    }
}
