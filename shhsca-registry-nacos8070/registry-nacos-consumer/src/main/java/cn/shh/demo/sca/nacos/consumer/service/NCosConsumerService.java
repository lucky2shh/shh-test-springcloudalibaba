package cn.shh.demo.sca.nacos.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component(value = "nCosConsumerService")
@FeignClient(value = "shhsca-registry-nacos-provider")
public interface NCosConsumerService {
    @GetMapping(value = "/nacos-provider/welcome/{name}")
    public String welcome(@PathVariable("name") String name);
}
