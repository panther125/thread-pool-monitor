package com.panther.dynamicthreadpoolstarter.domain;

import com.panther.dynamicthreadpoolstarter.domain.model.entity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * scheme
 *
 * @author Gin 琴酒
 * v.java 2024/7/7 22:30 $
 */
public interface IDynamicThreadPoolService {

    /**
     * 查询所有线程信息
     */
    List<ThreadPoolConfigEntity> queryThreadPoolList();

    /**
     * 查询单个线程信息
     */
    ThreadPoolConfigEntity queryThreadPoolConfigByName(String threadPoolName);

    /**
     * 跟新线程信息
     */
    void updateThreadPoolConfig(ThreadPoolConfigEntity threadPoolConfigEntity);


}
