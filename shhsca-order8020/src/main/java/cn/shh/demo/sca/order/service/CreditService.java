package cn.shh.demo.sca.order.service;

import cn.shh.demo.sca.order.service.fallback.CreditServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "credit-service", fallback = CreditServiceFallback.class)
public interface CreditService {
    @RequestMapping(value = "/cs/base/hello", method = RequestMethod.GET)
    public String hello();
}
