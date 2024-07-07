package com.panther.dynamicthreadpoolstarter.domain.model.ThreadPoolConfigEntityVO;

/**
 * scheme
 *
 * @author Gin 琴酒
 * ThreadPoolConfigEntityVO.java 2024/7/7 22:31 $
 */
public class ThreadPoolConfigEntityVO {

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 线程池名称
     */
    private String threadPoolName;

    /**
     * 核心线程数
     */
    private int corePoolSize;

    /**
     * 最大线程数
     */
    private int maximumPoolSize;

    /**
     * 当前活跃线程数
     */
    private int activeCount;

    /**
     * 当前池中线程数
     */
    private int poolSize;

    /**
     * 队列类型
     */
    private String queueType;

    /**
     * 当前队列任务数
     */
    private int queueSize;

    private long keepLiveTime;

    private String abortPolicy;

    public long getKeepLiveTime() {
        return keepLiveTime;
    }

    public void setKeepLiveTime(long keepLiveTime) {
        this.keepLiveTime = keepLiveTime;
    }

    public String getAbortPolicy() {
        return abortPolicy;
    }

    public void setAbortPolicy(String abortPolicy) {
        this.abortPolicy = abortPolicy;
    }

    /**
     * 队列剩余任务数
     */
    private int remainingCapacity;

    public ThreadPoolConfigEntityVO() {
    }

    public ThreadPoolConfigEntityVO(String appName, String threadPoolName) {
        this.appName = appName;
        this.threadPoolName = threadPoolName;
    }

    public String getAppName() {
        return appName;
    }

    public String getThreadPoolName() {
        return threadPoolName;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public int getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(int activeCount) {
        this.activeCount = activeCount;
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public int getRemainingCapacity() {
        return remainingCapacity;
    }

    public void setRemainingCapacity(int remainingCapacity) {
        this.remainingCapacity = remainingCapacity;
    }



}
