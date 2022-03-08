package com.example.demomybatiscursor.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demomybatiscursor.domain.User;
import com.example.demomybatiscursor.mapper.UserMapper;
import com.example.demomybatiscursor.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-03-08 21:33:50
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Resource
    private UserMapper userMapper;
    @Resource
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    private PlatformTransactionManager platformTransactionManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<User> selectUser1(Long limit) {
        List<User> userList = new ArrayList<>(16);
        try (Cursor<User> cursor = userMapper.selectUser(limit)) {
            cursor.forEach(userList::add);
        } catch (Exception e) {
            exceptionLog(e);
        }
        return userList;
    }

    @Override
    public List<User> selectUser2(Long limit) {
        List<User> userList = new ArrayList<>(16);
        try (
                SqlSession sqlSession = sqlSessionFactory.openSession();
                Cursor<User> cursor = sqlSession.getMapper(UserMapper.class).selectUser(limit)
        ) {
            cursor.forEach(userList::add);
        } catch (Exception e) {
            exceptionLog(e);
        }
        return userList;
    }

    @Override
    public List<User> selectUser3(Long limit) {
        List<User> userList = new ArrayList<>(16);
        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
        transactionTemplate.execute(status -> {
            try (Cursor<User> cursor = userMapper.selectUser(limit)) {
                cursor.forEach(userList::add);
            } catch (IOException e) {
                exceptionLog(e);
            }
            return null;
        });
        return userList;
    }

    private void exceptionLog(Exception e) {
        log.info("查询用户错误：【{}】", e.getMessage());
    }
}




