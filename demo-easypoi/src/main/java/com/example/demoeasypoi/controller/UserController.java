package com.example.demoeasypoi.controller;

import com.example.demoeasypoi.domain.dto.UserDTO;
import com.example.demoeasypoi.domain.vo.UserVO;
import com.example.demoeasypoi.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author 兰建青
 * @title: UserController
 * @projectName spring-boot-test
 * @description: TODO
 * @date 2021/12/16 12:04
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("api/user/add")
    public UserVO add(@RequestBody UserDTO userDTO) {
        return userService.add(userDTO);
    }

    @GetMapping(value = "api/user/exportUserList")
    public void exportUserList() {
        userService.exportUserList();
    }

    @PostMapping(value = "api/user/importUserList")
    @ResponseBody
    public boolean importUserList(@RequestPart("file") MultipartFile file) {
        return userService.importUserList(file);
    }
}
