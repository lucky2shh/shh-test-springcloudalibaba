package cn.shh.demo.sca.nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取nacos配置中心中的配置信息
 */

@RefreshScope
@RestController
@RequestMapping(value = "/nacos-client")
public class NCosConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/getConfigInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
