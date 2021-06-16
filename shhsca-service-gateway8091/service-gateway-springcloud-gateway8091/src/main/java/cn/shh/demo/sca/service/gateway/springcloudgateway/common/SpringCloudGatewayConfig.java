package cn.shh.demo.sca.service.gateway.springcloudgateway.common;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("SpringCloudGateway-news",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"));

        return routes.build();
    }
}
