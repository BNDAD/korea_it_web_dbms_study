package com.koreait.dbms_study.repository;

import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.entity.User;
import com.koreait.dbms_study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {

    @Autowired
    private PostMapper postMapper;
    public int addPost(Post post) {
        return postMapper.insert(post);
    }

    public List<Post> getPostList() {
        return postMapper.getPostList();
    }


    public Optional<Post> getUserByUserId(Integer postId) {
        return postMapper.getPostByPostId(postId);
    }

    public int editPost(Post post) {
        return PostMapper.editUser(post);
    }

    public int removePost(Integer postId) {
        return postMapper.removePost(postId);
    }
}
