package com.panther.dynamicthreadpooladmin;

import com.panther.dynamicthreadpoolstarter.config.DynamicThreadPoolAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DynamicThreadPoolAdminApplication {

    public static void main(String[] args)  {
        ConfigurableApplicationContext run = SpringApplication.run(DynamicThreadPoolAdminApplication.class, args);
        System.out.println(run.isActive());
        DynamicThreadPoolAutoConfig bean = run.getBean(DynamicThreadPoolAutoConfig.class);
        ThreadPoolExecutor threadPoolExecutor01 = (ThreadPoolExecutor)run.getBean("threadPoolExecutor01");
        System.out.println();
        while (true){
            // 创建一个随机时间生成器
            Random random = new Random();
            // 随机时间，用于模拟任务启动延迟
            int initialDelay = random.nextInt(10) + 1; // 1到10秒之间
            // 随机休眠时间，用于模拟任务执行时间
            int sleepTime = random.nextInt(10) + 1; // 1到10秒之间

            // 提交任务到线程池
            threadPoolExecutor01.submit(() -> {
                try {
                    // 模拟任务启动延迟
                    TimeUnit.SECONDS.sleep(initialDelay);
                    System.out.println("Task started after " + initialDelay + " seconds.");

                    // 模拟任务执行
                    TimeUnit.SECONDS.sleep(sleepTime);
                    System.out.println("Task executed for " + sleepTime + " seconds.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            try {
                Thread.sleep(random.nextInt(50) + 1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    };
}
