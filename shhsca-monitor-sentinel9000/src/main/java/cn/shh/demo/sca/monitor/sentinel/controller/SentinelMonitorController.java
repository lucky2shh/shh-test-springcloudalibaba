package cn.shh.demo.sca.monitor.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping(value = "/monitor-sentinel")
public class SentinelMonitorController {

    //------------------------------Sentinel 流控规则---------------------------
    /**
     * 测试 sentinel-流控规则-QPS
     * @return
     */
    @GetMapping(value = "/printA")
    public String printA(){
        return "shhsca-monitor-sentinel A";
    }

    /**
     * 测试 sentinel-流控规则-线程数
     * @return
     */
    @GetMapping(value = "/printB")
    public String printB(){
        log.info(Thread.currentThread().getName() + ", printB method is runing.");
        return "shhsca-monitor-sentinel B";
    }


    //------------------------------Sentinel 降级规则---------------------------
    /**
     * 测试 sentinel-降级规则-慢调用比例
     *
     * @return
     * @throws InterruptedException
     */
    @GetMapping(value = "/printC")
    public String printC() throws InterruptedException {
        log.info(Thread.currentThread().getName() + ", printC method is runing.");
        TimeUnit.SECONDS.sleep(1);
        return "shhsca-monitor-sentinel C";
    }
    /**
     * 测试 sentinel-降级规则-异常比例
     *
     * @return
     * @throws InterruptedException
     */
    @GetMapping(value = "/printD")
    public String printD()  {
        log.info(Thread.currentThread().getName() + ", printD method is runing.");
        int n = 10 / 0;
        return "shhsca-monitor-sentinel D";
    }
    /**
     * 测试 sentinel-降级规则-异常数
     *
     * @return
     * @throws InterruptedException
     */
    @GetMapping(value = "/printE")
    public String printE()  {
        log.info(Thread.currentThread().getName() + ", printE method is runing.");
        int n = 10 / 0;
        return "shhsca-monitor-sentinel E";
    }


    //-----------------------------Sentinel 热点规则-------------------------------
    @SentinelResource(value = "hk", blockHandler = "hk_handler")
    @GetMapping(value = "/hk")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){
        return "shhsca-monitor-sentinel hotkey.";
    }
    public String hk_handler(String p1, String p2, BlockException e){
        return "shhsca-monitor-sentinel hotkey handler: 服务器繁忙，请稍后再试！";
    }
}
