package cn.shh.demo.sca.order.service.fallback;

import cn.shh.demo.sca.order.service.StockService;
import org.springframework.stereotype.Component;

@Component(value = "stockServiceFallback")
public class StockServiceFallback implements StockService {
    @Override
    public String hello() {
        System.out.println("request stock-service error.");
        return "request stock-service error.";
    }
}
