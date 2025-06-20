package com.koreait.dbms_study.service;


import com.koreait.dbms_study.dto.AddPostReqDto;
import com.koreait.dbms_study.dto.EditPostReqDto;
import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.repository.PostRepository;
import com.koreait.dbms_study.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void addPost(AddPostReqDto dto) {
        if (!userRepository.existsById(dto.getUserId())) {
            throw new IllegalArgumentException("존재하지 않는 user_id입니다.");
        }
        postRepository.save(dto.toEntity());
    }

    public Post getPost(Integer postId) {
        return postRepository.findById(postId);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public void editPost(EditPostReqDto dto) {
        Post post = postRepository.findById(dto.getPostId());
        if (post == null) throw new IllegalArgumentException("존재하지 않는 post입니다.");
        Post updated = dto.toEntity();
        updated.setUserId(post.getUserId()); // userId는 변경 불가
        postRepository.update(updated);
    }

    public void deletePost(Integer postId) {
        postRepository.delete(postId);
    }
}