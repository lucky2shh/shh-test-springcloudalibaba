package cn.shh.demo.sca.registry.zookeeper.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/zks")
public class ZookeeperServerController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/get")
    public String getPort(){
        return "zookeeper registry server port: " + serverPort;
    }
}
