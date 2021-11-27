package com.allen.test;

import java.util.concurrent.*;

public class ThreadPoolCenter {
    private ThreadPoolCenter() {}

    public static class ThreadPool{
        //常驻核心线程数
        private static int corePoolSize = 5;
        //最大线程数
        private static int maximumPoolSize = 8;
        //当线程数大于核心数时，剩余空闲线程在终止之前等待新任务的最大时间
        private static long keepAliveTime = 2L;
        //阻塞队列大小
        private static int capacity = 2;
        private static ExecutorService INSTANCE = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }
    public static ExecutorService getThreadPool(){
        return ThreadPool.INSTANCE;
    }
}
