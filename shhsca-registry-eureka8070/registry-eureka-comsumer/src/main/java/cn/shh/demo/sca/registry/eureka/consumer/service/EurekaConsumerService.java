package cn.shh.demo.sca.registry.eureka.consumer.service;

import cn.shh.demo.sca.common.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "shhsca-registry-eureka-provider")
public interface EurekaConsumerService {
    @GetMapping(value = "/eureka-provider/get/{id}")
    public abstract CommonResult getPaymentById(@PathVariable("id") Long id);
}
