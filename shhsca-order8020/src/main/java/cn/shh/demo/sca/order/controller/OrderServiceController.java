package cn.shh.demo.sca.order.controller;

import cn.shh.demo.sca.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/base")
public class OrderServiceController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/createOrder", method = RequestMethod.GET)
    public String createOrder(){
        return orderService.createOrder();
    }
}
