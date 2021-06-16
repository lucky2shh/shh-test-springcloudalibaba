package cn.shh.demo.sca.order.controller;

import cn.shh.demo.sca.common.entity.CommonResult;
import cn.shh.demo.sca.common.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private static final String PAYMENT_URL = "http://shhsca-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/payment/add")
    public CommonResult add(Payment payment){
        log.info("order to payment: " + payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "获取失败");
        }
    }
}
