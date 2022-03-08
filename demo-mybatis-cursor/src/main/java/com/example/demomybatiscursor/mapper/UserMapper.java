package com.example.demomybatiscursor.mapper;

import com.example.demomybatiscursor.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-03-08 21:33:50
* @Entity com.example.demomybatiscursor.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user limit #{limit}")
    Cursor<User> selectUser(@Param("limit") Long limit);
}




