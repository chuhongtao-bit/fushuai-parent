/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MangerServiceApplication
 * Author:   康鸿
 * Date:     2019/8/5 14:19
 * Description: TODO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@RestController
public class MangerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangerServiceApplication.class,args);
    }

    @RequestMapping("serverhealth")
    public String serverhealth(){
        System.out.println("manager ok");
        return "ok";
    }
}