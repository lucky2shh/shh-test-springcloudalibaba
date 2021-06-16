package cn.shh.demo.sca.nacos.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/nacos-provider")
@Slf4j
public class NcosProviderController {

    @GetMapping(value = "/welcome/{name}")
    public String welcome(@PathVariable("name") String name){
        log.info("name: " + name);
        return "hi " + name + ", welcome to nacos provider.";
    }
}
