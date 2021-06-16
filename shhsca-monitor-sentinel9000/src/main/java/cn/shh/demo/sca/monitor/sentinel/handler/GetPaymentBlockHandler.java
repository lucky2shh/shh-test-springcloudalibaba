package cn.shh.demo.sca.monitor.sentinel.handler;

import cn.shh.demo.sca.common.entity.CommonResult;
import cn.shh.demo.sca.common.entity.Payment;
import com.alibaba.csp.sentinel.slots.block.BlockException;

public class GetPaymentBlockHandler {
    public static CommonResult getPayment_BlockHandler(Long id, BlockException exception){
        return new CommonResult(444, "shhsca-monitor-sentinel getPayment block-handler: 服务器繁忙，请稍后再试！", new Payment(id, "serial-001"));
    }
}
