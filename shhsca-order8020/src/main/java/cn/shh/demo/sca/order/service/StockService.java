package cn.shh.demo.sca.order.service;

import cn.shh.demo.sca.order.service.fallback.StockServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "stock-service", fallback = StockServiceFallback.class)
public interface StockService {
    @RequestMapping(value = "/ss/base/hello", method = RequestMethod.GET)
    public String hello();
}
