package cn.shh.demo.sca.nacos.consumer.controller;

import cn.shh.demo.sca.nacos.consumer.service.NCosConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/nacos-consumer")
@Slf4j
public class NcosConsumerController {
    private static final String PROVIDER_URL = "http://shhsca-registry-nacos-provider";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NCosConsumerService nCosConsumerService;

    /**
     * 基于注册中心 nacos 调用  nacos-provider 中API
     *
     * 注意：要想基于服务名来调用其他服务接口，需要讲注解@LoadBalanced
     *      标注于RestTemplate实例上。
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/provider/welcome/{name}")
    public String fromProvider2(@PathVariable("name") String name){
        log.info("name: " + name);
        return restTemplate.getForObject(PROVIDER_URL + "/nacos-provider/welcome/" + name, String.class);
    }

    @GetMapping(value = "/feign/provider/welcome/{name}")
    public String welcome(@PathVariable("name") String name){
        return nCosConsumerService.welcome(name);
    }
}
