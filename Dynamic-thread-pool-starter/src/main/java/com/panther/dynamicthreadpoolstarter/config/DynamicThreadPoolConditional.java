package com.panther.dynamicthreadpoolstarter.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Optional;

/**
 * scheme
 *
 * @author Gin 琴酒
 * DynamicThreadPoolConditional.java 2024/7/7 23:28 $
 */
public class DynamicThreadPoolConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String enable =
                Optional.ofNullable(context.getEnvironment().getProperty("dynamic.thread.pool.config.enable")).orElse("false");

        return enable.equalsIgnoreCase("true");
    }
}
