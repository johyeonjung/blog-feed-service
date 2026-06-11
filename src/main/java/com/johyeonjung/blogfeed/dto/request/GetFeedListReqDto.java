package com.johyeonjung.blogfeed.dto.request;

import lombok.Data;

@Data
public class GetFeedListReqDto {
    private int currentPage;
    private int size;
}
