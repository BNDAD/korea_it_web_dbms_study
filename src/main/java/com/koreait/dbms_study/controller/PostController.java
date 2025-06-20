package com.koreait.dbms_study.controller;

import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.dto.ApiRespDto;
import com.koreait.dbms_study.dto.EditPostReqDto;
import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ApiRespDto<Void> addPost(@RequestBody AddPostReqDto dto) {
        postService.addPost(dto);
        return new ApiRespDto<>("게시글 등록 성공", null);
    }

    @GetMapping("/{postId}")
    public ApiRespDto<Post> getPost(@PathVariable Integer postId) {
        return new ApiRespDto<>("조회 성공", postService.getPost(postId));
    }

    @GetMapping
    public ApiRespDto<List<Post>> getPosts() {
        return new ApiRespDto<>("전체 조회 성공", postService.getPosts());
    }

    @PutMapping
    public ApiRespDto<Void> editPost(@RequestBody EditPostReqDto dto) {
        postService.editPost(dto);
        return new ApiRespDto<>("수정 성공", null);
    }

    @DeleteMapping("/{postId}")
    public ApiRespDto<Void> deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return new ApiRespDto<>("삭제 성공", null);
    }
}