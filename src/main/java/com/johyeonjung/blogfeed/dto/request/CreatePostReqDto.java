package com.johyeonjung.blogfeed.dto.request;

import com.johyeonjung.blogfeed.entity.Post;
import com.johyeonjung.blogfeed.security.PrincipalUser;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class CreatePostReqDto {
    private String Visibility;
    private String content;
    private List<MultipartFile> files;

    public Post toEntity() {
        int  userId = PrincipalUser.getAuthenticatedPrincipalUser().getUser().getUserId();
        return Post.builder()
                .content(content)
                .visibility(Visibility)
                .userId(userId)
                .build();
    }
}
