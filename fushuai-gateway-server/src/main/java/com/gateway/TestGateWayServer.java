/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestGateWayServer
 * Author:   康鸿
 * Date:     2019/8/5 14:08
 * Description: TODO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gateway;

/**
 * Description: TODO
 *
 * @author 康鸿
 * @create 2019/8/5
 * @since 1.0.0
 * Description  GateWayServer的启动类
 */

import com.gateway.config.MyReslover;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestGateWayServer {
    public static void main(String[] args) {
        SpringApplication.run(TestGateWayServer.class, args);
    }

    @RequestMapping("serverhealth")
    public String serverhealth() {
        System.out.println("gateway ok");
        return "ok";
    }

    //    限流
    @Bean(name = "myAddrReslover")
    public MyReslover getMyReslover() {
        return new MyReslover();
    }
}