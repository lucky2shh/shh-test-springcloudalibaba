package cn.shh.demo.sca.nacos.config.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class NCosConfigConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
