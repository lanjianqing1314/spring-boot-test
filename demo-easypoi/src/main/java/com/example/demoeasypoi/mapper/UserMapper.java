package com.example.demoeasypoi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demoeasypoi.domain.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-03-13 12:36:58
* @Entity com.example.demoeasypoi.domain.po.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




