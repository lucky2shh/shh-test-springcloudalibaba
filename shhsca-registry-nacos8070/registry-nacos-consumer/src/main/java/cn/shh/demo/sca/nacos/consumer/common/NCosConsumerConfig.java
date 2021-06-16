package cn.shh.demo.sca.nacos.consumer.common;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NCosConsumerConfig {
    /**
     * 注入RestTemplate bean到容器中
     *
     * - 注解@LoadBalanced：使用restTemplate.getForObject时，可基于服务名实现调用。
     *
     * @return RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
