package cn.shh.demo.sca.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WmsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(WmsServiceApplication.class, args);
    }
}
