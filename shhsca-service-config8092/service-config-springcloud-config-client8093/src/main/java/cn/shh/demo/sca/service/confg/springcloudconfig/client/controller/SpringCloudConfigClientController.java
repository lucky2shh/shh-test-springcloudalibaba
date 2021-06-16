package cn.shh.demo.sca.service.confg.springcloudconfig.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value = "/scconfig-client")
public class SpringCloudConfigClientController {

    @Value("${config.name}")
    private String name;

    @GetMapping(value = "/getName")
    public String getName(){
        return name;
    }
}
