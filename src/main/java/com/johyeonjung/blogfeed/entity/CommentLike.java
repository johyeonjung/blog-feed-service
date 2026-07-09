package com.johyeonjung.blogfeed.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentLike {
    private int storyImageId;
    private int storyId;
    private String imageUrl;
}
