package cn.shh.demo.sca.registry.eureka.consumer_rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaConsumerSelfRule {
    /**
     *  负载均衡策略设为 随机。
     *
     *  可选策略如下：
     *    1、new RoundRobinRule(); // 轮询
     *    2、new RandomRule(); // 随机
     *    3、new RetryRule();
     *       先轮询，失败就重试，若限定时间内还是没有成功则放弃。
     *    4、new WeightedResponseTimeRule();
     *       根据平均响应时间计算权重，响应时间快的权重大。启动时因统计信息不足会
     *       暂时使用轮询，等待统计信息完整后再切换到此。
     *    5、new BestAvailableRule();
     *       先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发
     *       量最小的服务。
     *    6、new AvailabilityFilteringRule();
     *       先过滤掉故障服务，再选择并发量较小的实例。
     *    7、new ZoneAvoidanceRule();
     *       默认规则，复合判断server所在区域性能和server可用性来选择服务。
     *
     * @return
     */
    @Bean
    public IRule orderRule(){
        return new RandomRule();
    }
}
