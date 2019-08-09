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
import com.kh.pojo.entity.RoleInfo;

import com.kh.utils.TwitterIdWorker;
import com.manager.service.RoleMapperServerImpl;
import com.manager.service.RoleService;
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
public class RoleController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMapperServerImpl roleMapperServerImpl;

    /**
     * 角色全查
     */
    @RequestMapping("roleList")
    @ResponseBody
    public PageInfo<RoleInfo> roleList(@RequestBody Map<String, String> info) {
        ResponseResult responseResult = ResponseResult.getResponseResult();
        Integer page = Integer.parseInt(info.get("page"));
        Integer pageSize = Integer.parseInt(info.get("pageSize"));
        String name = info.get("name");
        //查
        PageInfo<RoleInfo> pageInfo = roleMapperServerImpl.roleList(page, pageSize, name);
        //将信息放入返回值
        responseResult.setResult(pageInfo);
        System.out.println(responseResult.getResult());
        return pageInfo;
    }


    //角色删除
    @RequestMapping("deleteRoleById")
    @ResponseBody
    public int deleteRoleById(@RequestBody Map<String, String> map) {
        Long id = Long.valueOf(map.get("id"));
        int i = roleService.deleteRoleById(id);
        return i;
    }

    //角色添加
    @RequestMapping("addRole")
    @ResponseBody
    public int addRole(@RequestBody RoleInfo r) {

        //设置id为雪花id
        TwitterIdWorker twitterIdWorker = new TwitterIdWorker();
        long id = twitterIdWorker.nextId();
        r.setId(id);
        //添加
        int i = roleService.addRole(r);
        return i;
    }

}