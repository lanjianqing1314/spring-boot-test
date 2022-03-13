package com.example.demoeasypoi.domain.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 兰建青
 * @title: UserController
 * @projectName spring-boot-test
 * @description: TODO
 * @date 2021/12/16 12:03
 */
@Data
@ToString
@Accessors(chain = true)
public class UserDTO implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private Date birthday;
    private String phone;
    private String icon;
    private Integer gender;
}