/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ResponseResult
 * Author:   康鸿
 * Date:     2019/8/5 16:09
 * Description: TODO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kh.pojo;

import lombok.Data;

/**
 * Description: TODO
 *
 * @author 康鸿
 * @create 2019/8/5
 * @since 1.0.0
 * Description 
 */
@Data
public class ResponseResult {

    //返回信息编码  0失败 1成功
    private int code;
    //错误信息
    private String error;
    //程序返回结果
    private Object result;
    //成功信息
    private String success;
    //创建实例
    public static ResponseResult getResponseResult(){
        return new ResponseResult();
    }
    //登陆成功的标识(这里存储了一些用户的信息)
    private String token;
    //用来表示token的一个唯一的字符串
    private String tokenkey;

    //选中的需要回显的菜单ID
    private Long[] menuIds;
}