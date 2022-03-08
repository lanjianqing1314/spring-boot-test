package com.example.demomybatiswebflux.mapper;

import com.example.demomybatiswebflux.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demomybatiswebflux.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-03-08 23:14:04
* @Entity com.example.demomybatiswebflux.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<UserVO> selectAllUser();

    UserVO selectUserById(@Param("id") Long id);
}




