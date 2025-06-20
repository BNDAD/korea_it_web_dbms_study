package com.koreait.dbms_study.mapper;

import com.koreait.dbms_study.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    int insert(User user);

    List<User> getUserList();

    Optional<User> getUserByUserId(Integer userId);

    int editUser(User user);

    int removeUser(Integer userId);

    @Select("SELECT COUNT(*) FROM user_tb WHERE user_id = #{userId}")
    int existsById(Integer userId);

}
