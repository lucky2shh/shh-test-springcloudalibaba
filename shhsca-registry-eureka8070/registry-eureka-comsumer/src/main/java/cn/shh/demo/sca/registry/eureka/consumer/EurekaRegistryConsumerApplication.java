package cn.shh.demo.sca.registry.eureka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 开启自定负载均衡策略，可通过将如下注解添加至启动类即可。
 * @RibbonClient(name = "shhsca-payment-service", configuration = OrderSelfRule.class)
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class EurekaRegistryConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaRegistryConsumerApplication.class, args);
    }
}
