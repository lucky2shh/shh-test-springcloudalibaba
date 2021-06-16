package cn.shh.demo.sca.order.service;

import cn.shh.demo.sca.order.service.fallback.WmsServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "wms-service", fallback = WmsServiceFallback.class)
public interface WmsService {
    @RequestMapping(value = "/ws/base/hello", method = RequestMethod.GET)
    public String hello();
}
