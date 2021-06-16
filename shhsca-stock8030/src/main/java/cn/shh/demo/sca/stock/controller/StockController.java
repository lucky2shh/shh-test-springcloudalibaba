package cn.shh.demo.sca.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/base")
public class StockController {
    @GetMapping(value = "/hello")
    public String hello(){
        System.out.println("request success, welcome to stock-service.");
        return "request success, welcome to stock-service.";
    }
}
