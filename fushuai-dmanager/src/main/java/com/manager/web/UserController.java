/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   康鸿
 * Date:     2019/8/8 14:17
 * Description: TODO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.manager.web;

import com.github.pagehelper.PageInfo;
import com.kh.pojo.ResponseResult;
import com.kh.pojo.entity.UserInfo;
import com.kh.utils.MD5;
import com.kh.utils.TwitterIdWorker;
import com.manager.service.UserMapperServerImpl;
import com.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Description: TODO
 *
 * @author 康鸿
 * @create 2019/8/8
 * @since 1.0.0
 * Description
 */

@Controller
public class UserController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapperServerImpl userMapperServerImpl;

    /**
     * 用户全查
     */
    @RequestMapping("userList")
    @ResponseBody
    public PageInfo<UserInfo> userList(@RequestBody Map<String, String> info) {
        ResponseResult responseResult = ResponseResult.getResponseResult();
        Integer page = Integer.parseInt(info.get("page"));
        Integer pageSize = Integer.parseInt(info.get("pageSize"));
        String data1 = info.get("data1");
        String data2 = info.get("data2");
        String sex = info.get("sex");
        String name = info.get("name");
        //查
        PageInfo<UserInfo> pageInfo = userMapperServerImpl.selectAll(page, pageSize, data1, data2, sex, name);
        //将信息放入返回值
        responseResult.setResult(pageInfo);
        System.out.println(responseResult.getResult());
        return pageInfo;
    }


    //删除
    @RequestMapping("deleteUserById")
    @ResponseBody
    public int deleteUserById(@RequestBody Map<String, String> map) {

        int i = userService.deleteUserById(Long.valueOf(map.get("id")));
        return i;
    }


    //增加
    @RequestMapping("addUser")
    @ResponseBody
    public int addUser(@RequestBody UserInfo userInfo) {
        //设置id为雪花id
        TwitterIdWorker twitterIdWorker = new TwitterIdWorker();
        long id = twitterIdWorker.nextId();
        userInfo.setId(id);
        //密码加密
        String password = MD5.encryptPassword(userInfo.getPassword(), "kh");
        userInfo.setPassword(password);

        int i = userService.addUser(userInfo);
        return i;
    }
    //修改
    @RequestMapping("updateUser")
    @ResponseBody
    public int updateUser(@RequestBody UserInfo userInfo) {

        //密码加密
        String password = MD5.encryptPassword(userInfo.getPassword(), "kh");
        userInfo.setPassword(password);

        int i = userService.updateUser(userInfo);
        return i;
    }


}