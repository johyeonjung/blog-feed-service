package com.johyeonjung.blogfeed.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommentMapperTest {

    @Autowired
    private CommentMapper commentMapper;
    @Test
    public void findAllCommentByPostIdTest() {
        System.out.println(commentMapper.findAllCommentByPostId(209));

    }
}
