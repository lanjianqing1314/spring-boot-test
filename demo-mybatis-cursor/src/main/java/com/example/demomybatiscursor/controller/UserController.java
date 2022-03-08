package com.example.demomybatiscursor.controller;

import com.example.demomybatiscursor.domain.User;
import com.example.demomybatiscursor.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 兰建青
 * @title: UserController
 * @projectName spring-boot-test
 * @description: TODO
 * @date 2022/3/821:39
 */
@RestController
public class UserController {
    @Resource
    private UserServiceImpl userService;

    @GetMapping("api/user/1/{limit}")
    public List<User> selectUser1(@PathVariable Long limit) {
        return userService.selectUser1(limit);
    }

    @GetMapping("api/user/2/{limit}")
    public List<User> selectUser2(@PathVariable Long limit) {
        return userService.selectUser2(limit);
    }

    @GetMapping("api/user/3/{limit}")
    public List<User> selectUser3(@PathVariable Long limit) {
        return userService.selectUser3(limit);
    }
}
