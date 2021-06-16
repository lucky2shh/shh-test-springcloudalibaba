package cn.shh.demo.sca.registry.zookeeper.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // 基于consul或zookeeper作为注册中心时，提供注册服务支持。
public class ZookeeperRegistryClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperRegistryClientApplication.class, args);
    }
}
