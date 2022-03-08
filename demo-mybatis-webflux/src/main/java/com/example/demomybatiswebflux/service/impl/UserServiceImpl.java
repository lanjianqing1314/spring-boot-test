package com.example.demomybatiswebflux.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomybatiswebflux.domain.User;
import com.example.demomybatiswebflux.domain.dto.UserDTO;
import com.example.demomybatiswebflux.domain.vo.UserVO;
import com.example.demomybatiswebflux.service.UserService;
import com.example.demomybatiswebflux.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-03-08 23:14:04
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserVO> selectUserList() {
        return userMapper.selectAllUser();
    }

    @Override
    public UserVO getById(Long id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public UserVO insert(UserDTO userDTO) {
        User user = BeanUtil.toBean(userDTO, User.class);
        userMapper.insert(user);
        return BeanUtil.toBean(user, UserVO.class);
    }

    @Override
    public Integer updateById(UserDTO userDTO) {
        return userMapper.updateById(BeanUtil.toBean(userDTO, User.class));
    }
}




