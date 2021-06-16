package cn.shh.demo.sca.registry.eureka.provider.controller;

import cn.shh.demo.sca.common.entity.CommonResult;
import cn.shh.demo.sca.registry.eureka.provider.service.EurekaProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/eureka-provider")
public class EurekaProviderController {
    @Autowired
    private EurekaProviderService eurekaProviderService;

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return eurekaProviderService.getPaymentById(id);
    }

    @GetMapping(value = "/payment/lb")
    public Integer getPaymentLB(){
        return eurekaProviderService.getPaymentLB();
    }


    // ------------------------服务降级--------------------------
    @GetMapping(value = "/hystrix/ok/{id}")
    public String hystrix_ok(@PathVariable("id") Integer id){
        return eurekaProviderService.hystrix_ok(id);
    }
    @GetMapping(value = "/hystrix/to/{id}")
    public String hystrix_timeout(@PathVariable("id") Integer id){
        return eurekaProviderService.hystrix_timeout(id);
    }


    // ------------------------服务熔断--------------------------
    @GetMapping(value = "/hystrix/cb/{id}")
    public String hystrix_CircuitBreaker(@PathVariable("id") Integer id){
        return eurekaProviderService.hystrix_CircuitBreaker(id);
    }

}
