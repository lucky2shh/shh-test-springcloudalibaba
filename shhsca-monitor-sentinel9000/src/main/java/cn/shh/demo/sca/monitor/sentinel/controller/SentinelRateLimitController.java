package cn.shh.demo.sca.monitor.sentinel.controller;

import cn.shh.demo.sca.common.entity.CommonResult;
import cn.shh.demo.sca.common.entity.Payment;
import cn.shh.demo.sca.monitor.sentinel.handler.GetPaymentFallbackHandler;
import cn.shh.demo.sca.monitor.sentinel.handler.GetPaymentBlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/sentinel-rl")
public class SentinelRateLimitController {

    @SentinelResource(value = "getPayment",
            blockHandlerClass = GetPaymentBlockHandler.class, // 服务于sentinel配置
            blockHandler = "getPayment_BlockHandler",
            fallbackClass = GetPaymentFallbackHandler.class,  // 服务于Java运行时异常
            fallback = "getPayment_FallbackHandler")
    @GetMapping(value = "/getPayment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        if (id < 0){
            throw new RuntimeException("id不能负数！");
        }
        return new CommonResult(200, "shhsca-monitor-sentinel getPayment.", new Payment(id, "serial-001"));
    }
}
