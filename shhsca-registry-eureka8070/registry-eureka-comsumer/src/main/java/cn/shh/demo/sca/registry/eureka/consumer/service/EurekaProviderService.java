package cn.shh.demo.sca.registry.eureka.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "SHHSCA-REGISTRY-EUREKA-PROVIDER", fallback = EurekaProviderServiceFallback.class)
public interface EurekaProviderService {

    //-------------------------服务降级-----------------------------
    @GetMapping(value = "/eureka-provider/hystrix/ok/{id}")
    public String hystrix_ok(@PathVariable("id") Integer id);
    @GetMapping(value = "/eureka-provider/hystrix/to/{id}")
    public String hystrix_timeout(@PathVariable("id") Integer id);

    //-------------------------服务熔断-----------------------------
    @GetMapping(value = "/eureka-provider/hystrix/cb/{id}")
    public String hystrix_CircuitBreaker(@PathVariable("id") Integer id);

}
