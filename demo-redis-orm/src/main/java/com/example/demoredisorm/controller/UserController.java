package com.example.demoredisorm.controller;

import com.example.demoredisorm.domain.User;
import com.example.demoredisorm.domain.dto.UserDTO;
import com.example.demoredisorm.domain.vo.UserVO;
import com.example.demoredisorm.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    private UserService userService;

    @PostMapping("api/user/add")
    public UserVO add(@RequestBody UserDTO userDTO) {
        return userService.add(userDTO);
    }

    @DeleteMapping("api/user/deleteById/{id}")
    public void deleteById(@RequestParam Long id) {
        userService.deleteById(id);
    }

    @GetMapping("api/user/selectById/{id}")
    public UserVO selectById(@RequestParam Long id) {
        return userService.selectById(id);
    }

    @GetMapping("api/user/selectPage/{pageNum}/{pageSize}")
    public Page<User> selectPage(@RequestParam(defaultValue = "0") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        return userService.selectPage(pageNum, pageSize);
    }
}
