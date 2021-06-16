package cn.shh.demo.sca.registry.eureka.provider.service;

import cn.hutool.core.util.IdUtil;
import cn.shh.demo.sca.common.entity.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class EurekaProviderService {
    @Value("${server.port}")
    private Integer port;

    public CommonResult getPaymentById(Long id){
        log.info("param id: " + id);
        return new CommonResult(200, "获取成功，端口：" + port);
    }
    public Integer getPaymentLB(){
        return port;
    }


    // ------------------------服务降级--------------------------
    public String hystrix_ok(Integer id){
        return "线程: " + Thread.currentThread().getName() + ", param id: " + id;
    }
    @HystrixCommand(fallbackMethod = "hystrix_timeout_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String hystrix_timeout(Integer id){
        int sleepTime = 5;
        try {
            TimeUnit.SECONDS.sleep(sleepTime);
        }catch (InterruptedException e){
            log.error("hystrix_TimeOut method error", e);
        }
        return "操作成功！端口: " + port + ", 线程: " + Thread.currentThread().getName() + ", param id: " + id +", time: " + sleepTime;
    }
    public String hystrix_timeout_handler(Integer id){
        return "服务器忙，请稍后再试！端口: " + port + ", 线程: " + Thread.currentThread().getName() + ", param id: " + id;
    }


    // ------------------------服务熔断--------------------------
    @HystrixCommand(fallbackMethod = "hystrix_CircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                     // 是否开启断路器功能
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),        // 请求次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")       // 失败率达到该指定值时跳闸
    })
    public String hystrix_CircuitBreaker(Integer id){
        if (id < 0){
            throw new RuntimeException("id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "操作成功！端口: " + port + ", 流水号：" + serialNumber;
    }
    public String hystrix_CircuitBreaker_fallback(Integer id){
        return "id 不能为负数，请重新尝试！";
    }
}
