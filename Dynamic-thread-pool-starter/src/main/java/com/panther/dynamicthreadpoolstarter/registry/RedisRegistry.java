package com.panther.dynamicthreadpoolstarter.registry;

import com.panther.dynamicthreadpoolstarter.domain.model.entity.ThreadPoolConfigEntity;
import com.panther.dynamicthreadpoolstarter.domain.model.valobj.RegistryEnumVO;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;

import java.time.Duration;
import java.util.List;

/**
 * scheme
 *
 * @author Gin 琴酒
 * RedisRegistry.java 2024/7/7 22:41 $
 */
public class RedisRegistry implements IRegistry {

    private final RedissonClient redissonClient;

    public RedisRegistry(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public void reportThreadPool(List<ThreadPoolConfigEntity> threadPoolEntities) {
        RList<ThreadPoolConfigEntity> list =
                redissonClient.getList(RegistryEnumVO.THREAD_POOL_CONFIG_LIST_KEY.getKey());
        // todo 优化去重上传 不需要每次全部上报
        //list.stream()
        //        .filter(e -> !list.contains(e))
        //        .forEach(e -> {
        //            list.remove(e);
        //            list.add(e);
        //        });
        list.delete();
        list.addAll(threadPoolEntities);
    }

    @Override
    public void reportThreadPoolConfigParameter(ThreadPoolConfigEntity threadPoolConfigEntity) {
        String cacheKey = RegistryEnumVO.THREAD_POOL_CONFIG_PARAMETER_LIST_KEY.getKey() + "_" + threadPoolConfigEntity.getAppName() + "_" + threadPoolConfigEntity.getThreadPoolName();
        RBucket<ThreadPoolConfigEntity> bucket = redissonClient.getBucket(cacheKey);
        bucket.set(threadPoolConfigEntity, Duration.ofDays(30));
    }
}
