package cn.shh.demo.sca.order.service.fallback;

import cn.shh.demo.sca.order.service.CreditService;
import org.springframework.stereotype.Component;

@Component
public class CreditServiceFallback implements CreditService {
    @Override
    public String hello() {
        System.out.println("request credit-service error.");
        return "request credit-service error.";
    }
}
