/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SsoServer
 * Author:   康鸿
 * Date:     2019/8/5 15:52
 * Description: TODO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: TODO
 *
 * @author 康鸿
 * @create 2019/8/5
 * @since 1.0.0
 * Description 
 */
@SpringBootApplication
@EnableJpaAuditing
@RestController
@EntityScan(basePackages = {"com.kh.pojo.**"})
public class SsoServer {
    public static void main(String[] args){
        SpringApplication.run(SsoServer.class, args);
    }

    @RequestMapping("health")
    public String health() {
        System.out.println("sso ok ");
        return "ok";
    }
}