package com.example.demomybatiswebflux.controller;

import com.example.demomybatiswebflux.domain.dto.UserDTO;
import com.example.demomybatiswebflux.domain.vo.UserVO;
import com.example.demomybatiswebflux.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author 兰建青
 * @title: UserController
 * @projectName spring-boot-test
 * @description: TODO
 * @date 2022/3/823:20
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("api/user/list")
    public Flux<UserVO> selectUserList() {
        return Flux.fromIterable(userService.selectUserList());
    }

    @GetMapping("api/user/{id}")
    public Mono<UserVO> getById(@PathVariable Long id) {
        return Mono.just(userService.getById(id));
    }

    @PostMapping("api/user/add")
    public Mono<UserVO> insert(@RequestBody UserDTO userDTO) {
        return Mono.just(userService.insert(userDTO));
    }

    @PutMapping("api/user/update-by-id")
    public Mono<Integer> updateById(@RequestBody UserDTO userDTO) {
        return Mono.just(userService.updateById(userDTO));
    }
}
