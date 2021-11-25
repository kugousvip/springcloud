package com.allen.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalanced {

    ServiceInstance instanses(List<ServiceInstance> serviceInstances);
}
