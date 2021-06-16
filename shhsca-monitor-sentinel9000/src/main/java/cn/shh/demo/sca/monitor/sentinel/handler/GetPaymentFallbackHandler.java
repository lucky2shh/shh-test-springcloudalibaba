package cn.shh.demo.sca.monitor.sentinel.handler;

import cn.shh.demo.sca.common.entity.CommonResult;
import cn.shh.demo.sca.common.entity.Payment;

public class GetPaymentFallbackHandler {
    public static CommonResult getPayment_FallbackHandler(Long id, Throwable exception){
        return new CommonResult(444, "shhsca-monitor-sentinel getPayment fallback-handler: " + exception.getMessage(), new Payment(id, "serial-001"));
    }
}
