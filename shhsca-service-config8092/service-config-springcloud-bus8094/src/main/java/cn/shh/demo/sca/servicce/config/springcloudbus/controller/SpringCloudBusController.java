package cn.shh.demo.sca.servicce.config.springcloudbus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/scbus")
public class SpringCloudBusController {
    @Value("${server.port}")
    private String port;
    @Value("${config.name}")
    private String name;

    @GetMapping(value = "/getName")
    public String getName(){
        return "server.port: " + port + ", config.name: " + name;
    }
}
