package com.example.demopool.thread;

import com.example.demopool.thread.execute.VisibleThreadPoolTaskExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ljq
 * @description 线程池配置
 */
@Configuration
@Slf4j
public class ThreadPoolConfig {

    @Resource
    private VisibleThreadPoolTaskExecutor visibleThreadPoolTaskExecutor;

    @Bean("myThreadPoolExecutor")
    public Executor myThreadPoolExecutor() {
        int processors = Runtime.getRuntime().availableProcessors();
        visibleThreadPoolTaskExecutor.setCorePoolSize(processors * 1);
        visibleThreadPoolTaskExecutor.setMaxPoolSize(processors * 10);
        visibleThreadPoolTaskExecutor.setQueueCapacity(500);
        visibleThreadPoolTaskExecutor.setKeepAliveSeconds(120);
        visibleThreadPoolTaskExecutor.setThreadNamePrefix("my-thread-pool");
        // 当无线程可用时，丢弃，默认是使用当前请求线程
        visibleThreadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 关闭线程池时等待当前调度任务完成再关闭
        visibleThreadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        // 等待时间
        visibleThreadPoolTaskExecutor.setAwaitTerminationSeconds(60);
        visibleThreadPoolTaskExecutor.initialize();
        return visibleThreadPoolTaskExecutor;
    }
}