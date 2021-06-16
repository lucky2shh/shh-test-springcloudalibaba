package cn.shh.demo.sca.service.config.springcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * 基于gitee的配置中心
 *
 * 访问格式有以下几种：
 *  1、/{label}/{application}-{profile}.yml
 *  2、/{application}-{profile}.yml
 *  3、/{application}/{profile}/{label}.yml
 *
 *  要想实现gitee更新完数据后，所有服务能获取到最新的数据，只需
 *  执行如下POST请求即可通知其它所有服务：
 *    curl -X POST "http://localhost:8092/actuator/bus-refresh"
 *  8092端和配置中心直连，它在收到数据变动通知后会发送变动至其它服
 *  务，其它服务在收到该变动通知后，就会获取最新数据。
 *
 *  思考
 *  - 如何只通知其中一部分服务？
 *    只需在请求连接最后加上需要通知的服务和端口即可，比如：
 *    curl -X POST "http://localhost:8092/actuator/bus-refresh/SHHSCA-CONFIGCENTER-SPRINGCLOUDCONFIG-CLIENT:8093"
 *
 */

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigApplication.class, args);
    }
}
