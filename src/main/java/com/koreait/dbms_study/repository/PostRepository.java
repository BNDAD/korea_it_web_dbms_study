package com.koreait.dbms_study.repository;

import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.entity.User;
import com.koreait.dbms_study.mapper.PostMapper;
import com.koreait.dbms_study.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final PostMapper postMapper;

    public int save(Post post) {
        return postMapper.insertPost(post);
    }

    public Post findById(Integer postId) {
        return postMapper.selectPostById(postId);
    }

    public List<Post> findAll() {
        return postMapper.selectAllPosts();
    }

    public int update(Post post) {
        return postMapper.updatePost(post);
    }

    public int delete(Integer postId) {
        return postMapper.deletePost(postId);
    }
}