package cn.shh.demo.sca.registry.consul.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping(value = "/consul-c")
public class ConsulClientController {
    private static final String PAYMENT_URL = "http://shhsca-registry-consul-service";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/get")
    public String getPort(){
        String result = restTemplate.getForObject(PAYMENT_URL + "/consul-s/get", String.class);
        log.info("getPort result: " + result);
        return result;
    }
}
