package com.johyeonjung.blogfeed.dto.request;

import com.johyeonjung.blogfeed.entity.Post;
import com.johyeonjung.blogfeed.security.PrincipalUser;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class CreatePostReqDto {
    private String visibility;
    private String content;
    private String tagContent;
    private List<MultipartFile> files;

    public Post toEntity() {
        Long  userId = PrincipalUser.getAuthenticatedPrincipalUser().getUser().getUserId();
        return Post.builder()
                .visibility(visibility)
                .content(content)
                .tagContent(tagContent)
                .userId(userId)
                .build();
    }
}
