package cn.shh.demo.sca.servicce.config.springcloudbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudBusApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudBusApplication.class, args);
    }
}
