package cn.shh.demo.sca.registry.eureka.consumer.controller;

import cn.shh.demo.sca.common.entity.CommonResult;
import cn.shh.demo.sca.registry.eureka.consumer.lb.service.LoadBalancer;
import cn.shh.demo.sca.registry.eureka.consumer.service.EurekaConsumerService;
import cn.shh.demo.sca.registry.eureka.consumer.service.EurekaProviderService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/eureka-consumer")
public class EurekaConsumerController {
    private static final String PAYMENT_URL = "http://shhsca-registry-eureka-provider";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private EurekaConsumerService eurekaConsumerService;
    @Autowired
    private EurekaProviderService eurekaProviderService;

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        log.info("param id: " + id);
        return restTemplate.getForObject(PAYMENT_URL + "/eureka-provider/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/payment/lb")
    public Integer getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("shhsca-registry-eureka-provider");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        log.info("serviceInstance: " + serviceInstance);
        log.info("uri: " + uri);

        return restTemplate.getForObject(uri + "/eureka-provider/payment/lb", Integer.class);
    }

    /**
     * 基于openFeign实现服务间调用
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/feign/get/{id}")
    public CommonResult getPaymentById2(@PathVariable("id") Long id){
        return eurekaConsumerService.getPaymentById(id);
    }

    //-------------------------服务降级-----------------------------
    @GetMapping(value = "/hystrix/provider/ok/{id}")
    public String hystrix_ok(@PathVariable("id") Integer id){
        return eurekaProviderService.hystrix_ok(id);
    }
    @GetMapping(value = "/hystrix/provider/to/{id}")
    public String hystrix_timeout(@PathVariable("id") Integer id){
        return eurekaProviderService.hystrix_timeout(id);
    }

    //-------------------------服务熔断-----------------------------
    @GetMapping(value = "/hystrix/provider/cb/{id}")
    public String hystrix_CircuitBreaker(@PathVariable("id") Integer id){
        return eurekaProviderService.hystrix_CircuitBreaker(id);
    }

}
