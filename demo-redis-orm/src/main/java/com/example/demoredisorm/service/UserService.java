package com.example.demoredisorm.service;

import com.example.demoredisorm.domain.User;
import com.example.demoredisorm.domain.dto.UserDTO;
import com.example.demoredisorm.domain.vo.UserVO;
import org.springframework.data.domain.Page;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service
* @createDate 2022-03-08 21:33:50
*/
public interface UserService {
    UserVO add(UserDTO userDTO);

    void deleteById(Long id);

    UserVO selectById(Long id);

    Page<User> selectPage(Integer pageNum, Integer pageSize);
}
