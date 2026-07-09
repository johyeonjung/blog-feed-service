package com.johyeonjung.blogfeed.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HighlightStory {
    private Long highlightStoryId;
    private Long highlightId;
    private Long storyId;
}
