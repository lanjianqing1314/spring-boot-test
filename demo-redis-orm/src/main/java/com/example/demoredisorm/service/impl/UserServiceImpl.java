package com.example.demoredisorm.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.example.demoredisorm.domain.User;
import com.example.demoredisorm.domain.dto.UserDTO;
import com.example.demoredisorm.domain.vo.UserVO;
import com.example.demoredisorm.repository.UserRepository;
import com.example.demoredisorm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-03-08 21:33:50
*/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Override
    public UserVO add(UserDTO userDTO) {
        User user = BeanUtil.toBean(userDTO, User.class);
        return BeanUtil.toBean(userRepository.save(user), UserVO.class) ;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserVO selectById(Long id) {
        Optional<User> result = userRepository.findById(id);
        return BeanUtil.toBean(result.orElse(null), UserVO.class);
    }

    @Override
    public Page<User> selectPage(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<User> pageResult = userRepository.findAll(pageable);
        return pageResult;
    }
}




