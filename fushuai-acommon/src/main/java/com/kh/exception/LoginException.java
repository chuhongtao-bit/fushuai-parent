/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginException
 * Author:   康鸿
 * Date:     2019/8/5 11:58
 * Description: TODO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kh.exception;

/**
 * Description: TODO
 *
 * @author 康鸿
 * @create 2019/8/5
 * @since 1.0.0 自定义的登录异常类
 * Description 
 */
public class LoginException extends Exception {
    public LoginException(String message){
        super(message);
    }
}