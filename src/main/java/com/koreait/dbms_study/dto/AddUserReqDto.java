package com.koreait.dbms_study.dto;


import com.koreait.dbms_study.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddUserReqDto {
    private String username;
    private String email;

    public User toEntity() {
        return User.builder()
                .username(this.username)
                .email(this.email)
                .build();
    }
}