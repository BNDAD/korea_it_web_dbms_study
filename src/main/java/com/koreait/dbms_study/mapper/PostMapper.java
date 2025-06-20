package com.koreait.dbms_study.mapper;

import com.koreait.dbms_study.entity.Post;
import com.koreait.dbms_study.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
    int insertPost(Post post);
    Post selectPostById(@Param("postId") Integer postId);
    List<Post> selectAllPosts();
    int updatePost(Post post);
    int deletePost(@Param("postId") Integer postId);
}