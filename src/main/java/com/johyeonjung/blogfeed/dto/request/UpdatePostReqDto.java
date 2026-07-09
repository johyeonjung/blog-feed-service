package com.johyeonjung.blogfeed.dto.request;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdatePostReqDto {
    private String content;
    private String visibility;
    private String tag_content;
    private LocalDate updated_at;

}
