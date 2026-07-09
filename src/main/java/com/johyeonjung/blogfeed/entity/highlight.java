package com.johyeonjung.blogfeed.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class highlight {
    private int highlightId;
    private int userId;
    private String title;
    private String coverImageUrl;
    private LocalDate createdAt;
}
