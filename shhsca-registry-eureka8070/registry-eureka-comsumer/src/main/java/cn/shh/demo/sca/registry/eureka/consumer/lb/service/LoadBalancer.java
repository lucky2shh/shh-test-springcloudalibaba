package cn.shh.demo.sca.registry.eureka.consumer.lb.service;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
