package cn.shh.demo.sca.service.confg.springcloudconfig.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 *
 * 访问springcloud config配置中心
 *
 * 访问格式有以下几种：
 *  1、/{label}/{application}-{profile}.yml
 *  2、/{application}-{profile}.yml
 *  3、/{application}/{profile}/{label}.yml
 *
 *  注意：修改配置中心中的配置项参数后，config client端无法实时获取
 *       最新数据，但可通过如下请求来激活，使其可以获取到最新数据。
 *       curl -X POST "http://localhost:8093/actuator/refresh"
 */

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }
}
