package cn.shh.demo.sca.registry.eureka.consumer.service;

import org.springframework.stereotype.Component;

@Component
public class EurekaProviderServiceFallback implements EurekaProviderService{
    @Override
    public String hystrix_ok(Integer id) {
        return "[hystrix_ok request] provider error, id: " + id;
    }
    @Override
    public String hystrix_timeout(Integer id) {
        return "[hystrix_timeout] request provider error, id: " + id;
    }

    @Override
    public String hystrix_CircuitBreaker(Integer id) {
        return "[hystrix_CircuitBreaker] request provider error, id: " + id;
    }
}
