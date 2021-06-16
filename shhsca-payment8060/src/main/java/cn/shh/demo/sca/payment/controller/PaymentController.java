package cn.shh.demo.sca.payment.controller;

import cn.shh.demo.sca.common.entity.CommonResult;
import cn.shh.demo.sca.common.entity.Payment;
import cn.shh.demo.sca.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/add")
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("add status: " + result);

        if (result > 0){
            return new CommonResult(200, "插入成功", result);
        }else{
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("add status: " + payment);

        if (payment != null){
            return new CommonResult(200, "查找成功", payment);
        }else{
            return new CommonResult(444, "数据不存在", null);
        }
    }
}
