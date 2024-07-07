package com.panther.dynamicthreadpoolstarter.registry;

import com.panther.dynamicthreadpoolstarter.domain.model.entity.ThreadPoolConfigEntity;

import java.util.List;

/**
 * scheme
 *
 * @author Gin 琴酒
 * IRegistry.java 2024/7/7 22:41 $
 */
public interface IRegistry {

    void reportThreadPool(List<ThreadPoolConfigEntity> threadPoolEntities);

    void reportThreadPoolConfigParameter(ThreadPoolConfigEntity threadPoolConfigEntity);


}
