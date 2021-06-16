package cn.shh.demo.sca.registry.zookeeper.client.controller;

import cn.shh.demo.sca.common.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping(value = "/zkc")
public class ZookeeperClientController {
    private static final String PAYMENT_URL = "http://shhsca-registry-zookeeper-service";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/get")
    public String getPort(){
        String result = restTemplate.getForObject(PAYMENT_URL + "/zks/get", String.class);
        log.info("getPort result: " + result);
        return result;
    }
}
