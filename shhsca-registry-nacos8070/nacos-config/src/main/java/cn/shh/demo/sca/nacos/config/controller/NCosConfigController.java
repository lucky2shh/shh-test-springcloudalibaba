package cn.shh.demo.sca.nacos.config.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.common.Constants;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Properties;

@RestController
@RequestMapping(value = "/loadInfo")
public class NCosConfigController {
    private static final String SERVER_ADDR = "127.0.0.1:8848";
    private static final String SHHSCA_NAMESPACE = "5f90237f-3796-47e9-9afd-258fba2843ab";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/type1")
    public String loadInfoFromNacos_NacosFactory() throws NacosException {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, SERVER_ADDR);
        properties.put(PropertyKeyConst.NAMESPACE, SHHSCA_NAMESPACE);

        ConfigService service = NacosFactory.createConfigService(properties);
        String content = service.getConfig("data01", "nacos-config-test", 3000L);

        return content;
    }

    @GetMapping(value = "/type2")
    public String loadInfoFromNacos_NacosAPI() throws NacosException {
        String requestUrl = "http://" + SERVER_ADDR + "/nacos" + Constants.CONFIG_CONTROLLER_PATH +
                "?tenant="+SHHSCA_NAMESPACE +
                "&dataId=data01" +
                "&group=nacos-config-test";
        return restTemplate.getForObject(requestUrl, String.class);
    }
}
