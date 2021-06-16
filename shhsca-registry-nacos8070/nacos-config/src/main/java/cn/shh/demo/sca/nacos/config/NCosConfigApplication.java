package cn.shh.demo.sca.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class NCosConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(NCosConfigApplication.class, args);
    }
}
