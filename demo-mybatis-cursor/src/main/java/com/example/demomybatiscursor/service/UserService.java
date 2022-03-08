package com.example.demomybatiscursor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomybatiscursor.domain.User;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service
* @createDate 2022-03-08 21:33:50
*/
public interface UserService extends IService<User> {
    List<User> selectUser1(Long limit);

    List<User> selectUser2(Long limit);

    List<User> selectUser3(Long limit);
}
