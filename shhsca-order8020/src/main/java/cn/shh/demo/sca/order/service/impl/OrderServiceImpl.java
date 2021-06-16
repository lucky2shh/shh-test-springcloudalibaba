package cn.shh.demo.sca.order.service.impl;

import cn.shh.demo.sca.order.service.CreditService;
import cn.shh.demo.sca.order.service.OrderService;
import cn.shh.demo.sca.order.service.StockService;
import cn.shh.demo.sca.order.service.WmsService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private StockService stockService;
    @Autowired
    private CreditService creditService;
    @Autowired
    private WmsService wmsService;

    @GlobalTransactional
    public String createOrder(){
        stockService.hello();
        creditService.hello();
        wmsService.hello();
        log.info("订单创建成功");
        return "success";
    }
}
