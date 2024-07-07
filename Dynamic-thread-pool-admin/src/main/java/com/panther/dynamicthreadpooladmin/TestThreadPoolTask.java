package com.panther.dynamicthreadpooladmin;

import com.panther.dynamicthreadpoolstarter.config.DynamicThreadPoolAutoProperties;
import com.panther.dynamicthreadpoolstarter.domain.model.valobj.rejectHandlerPolicyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * scheme
 *
 * @author Gin 琴酒
 * TestThreadPoolTask.java 2024/7/8 0:14 $
 */
@Slf4j
@EnableAsync
@Configuration
@EnableConfigurationProperties(DynamicThreadPoolAutoProperties.class)
public class TestThreadPoolTask {

    @Bean("threadPoolExecutor01")
    public ThreadPoolExecutor threadPoolExecutor01() {
        // 创建线程池
        return new ThreadPoolExecutor(10,
                50,
                100,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(200),
                Executors.defaultThreadFactory(),
                rejectHandlerPolicyEnum.ABORT_POLICY.getRejectPolicy());
    }

    @Bean("threadPoolExecutor02")
    public ThreadPoolExecutor threadPoolExecutor02() {
        // 创建线程池
        return new ThreadPoolExecutor(5,
                20,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(200),
                Executors.defaultThreadFactory(),
                rejectHandlerPolicyEnum.DISCARD_OLDEST_POLICY.getRejectPolicy());
    }


}
