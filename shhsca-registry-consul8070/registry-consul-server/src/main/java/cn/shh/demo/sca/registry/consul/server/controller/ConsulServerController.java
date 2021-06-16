package cn.shh.demo.sca.registry.consul.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/consul-s")
public class ConsulServerController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/get")
    public String getPort(){
        return "consul registry server port: " + serverPort;
    }

}
