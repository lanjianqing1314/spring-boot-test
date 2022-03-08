package com.example.demomybatiswebflux.service;

import com.example.demomybatiswebflux.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demomybatiswebflux.domain.dto.UserDTO;
import com.example.demomybatiswebflux.domain.vo.UserVO;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service
* @createDate 2022-03-08 23:14:04
*/
public interface UserService extends IService<User> {
    List<UserVO> selectUserList();
    UserVO getById(Long id);
    UserVO insert(UserDTO userDTO);
    Integer updateById(UserDTO userDTO);
}
