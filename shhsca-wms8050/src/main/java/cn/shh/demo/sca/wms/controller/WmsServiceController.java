package cn.shh.demo.sca.wms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/base")
public class WmsServiceController {
    @GetMapping(value = "/hello")
    public String hello(){
        System.out.println("request success, welcome to wms-service.");
        return "request success, welcome to wms-service.";
    }
}
