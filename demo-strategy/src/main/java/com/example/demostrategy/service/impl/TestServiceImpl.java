package com.example.demostrategy.service.impl;

import com.example.demostrategy.domain.bo.TestBO;
import com.example.demostrategy.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author 兰建青
 * @description TODO
 * @date 2021/1/18
 */
@Service
public class TestServiceImpl implements TestService {

    private static final Map<String, Function<TestBO, Long>> STRATEGY_PATTERN_MAP = new HashMap<>(16);

    /**
     * 利用策略模式实现计算
     */
    @PostConstruct
    public void strategyPatternInit(){
        STRATEGY_PATTERN_MAP.put("key1", this::test1);
        STRATEGY_PATTERN_MAP.put("key2", this::test2);
    }

    @Override
    public Long test(String param) {
        TestBO testBO = new TestBO();
        testBO.setValue(100L);
        Function<TestBO, Long> result = STRATEGY_PATTERN_MAP.get(param);
        if (result == null) {
            return -1L;
        }
        return result.apply(testBO);
    }

    private Long test1(TestBO testBO) {
        System.out.println("test1");
        return 1L + testBO.getValue();
    }

    private Long test2(TestBO testBO) {
        System.out.println("test2");
        return 1L + testBO.getValue();
    }
}
