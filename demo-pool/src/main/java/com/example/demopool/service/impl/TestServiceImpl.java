package com.example.demopool.service.impl;

import com.example.demopool.service.TestService;
import com.example.demopool.thread.execute.VisibleThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author 兰建青
 * @description TODO
 * @date 2021/1/18
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private VisibleThreadPoolTaskExecutor visibleThreadPoolTaskExecutor;

    @Override
    public List<Long> test() {
        List<Long> list = new ArrayList<>(16);
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        List<CompletableFuture<Long>> completableFutures = list.stream().map(value -> CompletableFuture.supplyAsync(() -> this.count(value), visibleThreadPoolTaskExecutor)).collect(Collectors.toList());
        list = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        return list;
    }

    private Long count(Long value) {
        for (int i = 1; i < 100; i++) {
            value = value + i;
        }
        return value;
    }

}
