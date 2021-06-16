package cn.shh.demo.sca.order.service.fallback;

import cn.shh.demo.sca.order.service.WmsService;
import org.springframework.stereotype.Component;

@Component
public class WmsServiceFallback implements WmsService {
    @Override
    public String hello() {
        System.out.println("request wms-service error.");
        return "request wms-service error.";
    }
}
