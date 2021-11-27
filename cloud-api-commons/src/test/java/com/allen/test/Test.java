package com.allen.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //List<Future<AtomicInteger>> futures = new ArrayList<>();
        List<Future<Integer>> futures = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            Future<Integer> future = ThreadPoolCenter.getThreadPool().submit(()->{
                Integer result = new Integer(0);
                for (int k = 1;k<= 100;k++){
                    //int tmp = result.get();
                    //result.compareAndSet(tmp,tmp+k);
                    result += k;
                }
                //System.out.println("第"+Thread.currentThread().getName()+"个线程执行了任务,结果为："+result.get());
                System.out.println("第"+Thread.currentThread().getName()+"个线程执行了任务,结果为："+result);
                return result;
            });
            futures.add(future);
        }
        int total = 0;
        for (Future<Integer> future : futures) {
            //total += future.get().get();
            total += future.get();
        }
        System.out.println("结果值："+total);
    }
}
