package com.panther.dynamicthreadpoolstarter.domain.model.valobj;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Gin 琴酒
 * @data 2024/7/8 0:58
 */
public enum rejectHandlerPolicyEnum {

    ABORT_POLICY(1, new ThreadPoolExecutor.AbortPolicy(),"抛出异常!"),
    CALLER_RUNS_POLICY(2, new ThreadPoolExecutor.CallerRunsPolicy(),"调用者自己处理任务!"),
    DISCARD_POLICY(3, new ThreadPoolExecutor.DiscardPolicy(),"丢弃任务队列中最老的任务!"),
    DISCARD_OLDEST_POLICY(4, new ThreadPoolExecutor.DiscardOldestPolicy(),"丢弃掉当前任务！");


    private final Integer type;

    private final RejectedExecutionHandler rejectPolicy;

    private final String description;

    public Integer getType() {
        return type;
    }

    public RejectedExecutionHandler getRejectPolicy() {
        return rejectPolicy;
    }

    rejectHandlerPolicyEnum(Integer type, RejectedExecutionHandler rejectPolicy, String description) {
        this.type = type;
        this.rejectPolicy = rejectPolicy;
        this.description = description;
    }

    public static rejectHandlerPolicyEnum getRejectPolicyByType(Integer type) {
        for (rejectHandlerPolicyEnum policy : values()) {
            if (policy.getType().equals(type))
                return policy;
        }
        return null;
    }
}
