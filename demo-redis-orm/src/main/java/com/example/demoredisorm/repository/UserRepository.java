package com.example.demoredisorm.repository;

import com.example.demoredisorm.domain.User;
import com.redis.om.spring.repository.RedisDocumentRepository;

/**
 * @Description TODO
 * @Author 兰建青
 * @Date 2022/3/10 13:08
 **/
public interface UserRepository extends RedisDocumentRepository<User, Long> {
}