package com.allen.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟轮询负载均衡算法
 */
@Component
public class MyLB implements LoadBalanced{
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 :current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*******第"+next+"次调用**********");
        return next;
    }
    @Override
    public ServiceInstance instanses(List<ServiceInstance> serviceInstances) {
        int index = this.getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
