package com.johyeonjung.blogfeed.service;

import com.johyeonjung.blogfeed.dto.request.CreatePostReqDto;
import com.johyeonjung.blogfeed.dto.request.GetFeedListReqDto;
import com.johyeonjung.blogfeed.dto.request.UpdatePostReqDto;
import com.johyeonjung.blogfeed.dto.response.PaginationRespDto;
import com.johyeonjung.blogfeed.dto.response.PostResponse;
import com.johyeonjung.blogfeed.entity.Post;
import com.johyeonjung.blogfeed.entity.PostImage;
import com.johyeonjung.blogfeed.entity.User;
import com.johyeonjung.blogfeed.mapper.PostImageMapper;
import com.johyeonjung.blogfeed.mapper.PostMapper;
import com.johyeonjung.blogfeed.security.PrincipalUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;
    private  final PostImageMapper postImageMapper;


    //여기서부터 고치기
    @Transactional(rollbackFor = Exception.class)
    public void createPost(CreatePostReqDto dto) {
        Long userId = PrincipalUser.getAuthenticatedPrincipalUser().getUser().getUserId();
        Post post = dto.toEntity(userId);
        postMapper.insert(post);
        List<MultipartFile> imagefiles = dto.getFiles();

        if (imagefiles == null || imagefiles.isEmpty()) {
            return;
        }

        String uploadUrl = "C:/uploads/blogfeed/post/";

        File dir = new File(uploadUrl);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        int imageOrder = 1;
        for (MultipartFile file : imagefiles) {
            if (file.isEmpty()) {
                continue;
            }
            String originalFilename = file.getOriginalFilename();
            String savedFilename = UUID.randomUUID() + "_" + originalFilename;

            File savedFile = new File(uploadUrl + savedFilename);

            try {
                file.transferTo(savedFile);
            } catch (IOException e) {
                throw new RuntimeException("이미지 저장 실패", e);
            }


            //url 이후 수정해보기
            PostImage postImage = PostImage.builder()
                    .postId(post.getPostId())
                    .imageUrl("/uploads/blogfeed/post/" + savedFilename)
                    .imageOrder(imageOrder++)
                    .build();
            postImageMapper.insert(postImage);
        }



    }

    public PostResponse getPost(Long postId) {
        Long userId = PrincipalUser.getAuthenticatedPrincipalUser().getUser().getUserId();

        PostResponse post = postMapper.getPost(postId,userId);

        List<String> imageUrls = postImageMapper.getImageUrlByPostId(postId);
        post.setImageUrls(imageUrls);

        return post;



        }


        public List<PostResponse> getUserPosts(String instagramId) {
        Long userId = PrincipalUser.getAuthenticatedPrincipalUser().getUser().getUserId();
            List<PostResponse> posts = postMapper.getUserPosts(instagramId, userId);

            for (PostResponse post : posts) {
                List<String> imageUrls = postImageMapper.getImageUrlByPostId(post.getPostId());

                post.setImageUrls(imageUrls);
            }
            return posts;

        }


    public PaginationRespDto<PostResponse> getFeeds(GetFeedListReqDto dto) {
        int size = dto.getSize();
        int startIndex = (dto.getCurrentPage() -1) * size;

        //유저아이디 들고와서 조회
        User user = PrincipalUser.getAuthenticatedPrincipalUser().getUser();
        List<PostResponse> feeds = postMapper.getFeeds(startIndex, size, user.getUserId());
        //게시글이 총 몇개인지
        int totalElements = postMapper.getTotalCount(user.getUserId());
        int totalPages = (int) Math.ceil(((double)totalElements)/ size);
        return PaginationRespDto.<PostResponse> builder()
                .contents(feeds)
                .currentPage(dto.getCurrentPage())
                .size(size)
                .totalElements(totalElements)
                .totalPages(totalPages)
                .isLast(dto.getCurrentPage() == totalPages)
                .build();
    }

    public PostResponse updatePost(Long postId, UpdatePostReqDto dto) {
        int update = postMapper.updatePost(postId,dto);

        if (update == 0) {

        }
        return getPost(postId);

    }
    //post_id FK에 ON DELETE CASCADE
    public void deletePost(Long postId) {
        int delete = postMapper.deletePost(postId);
    }
}