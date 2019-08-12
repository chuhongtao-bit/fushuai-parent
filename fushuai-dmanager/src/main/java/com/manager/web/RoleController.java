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

import com.kh.pojo.ResponseResult;
import com.kh.pojo.entity.MenuInfo;
import com.kh.pojo.entity.RoleInfo;

import com.kh.utils.TwitterIdWorker;
import com.manager.dao.MenuDao;
import com.manager.service.RoleService;
import com.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
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
    private MenuDao menuDao;



    /**
     * 角色全查
     */
    @RequestMapping("roleList")
    @ResponseBody
    public Object userList(@RequestBody Map<String, String> info) {
        Integer page = Integer.parseInt(info.get("page"));
        Integer pageSize = Integer.parseInt(info.get("pageSize"));
        String name = info.get("name");
        return roleService.roleList(page, pageSize, name);
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

//权限回显
    @RequestMapping("/findMenu")
    @ResponseBody
    public List<MenuInfo> findMenu(){

        return getForMenuInfo(0L);
    }

    public List<MenuInfo> getForMenuInfo(Long mid){
        List<MenuInfo> firstMenuInfo = menuDao.findByParentId(mid);
        if(firstMenuInfo!=null){
            for (MenuInfo menuInfo : firstMenuInfo) {
                menuInfo.setMenuInfoList(getForMenuInfo(menuInfo.getId()));
            }
        }
        return firstMenuInfo;
    }




    @Autowired
    JdbcTemplate jdbcTemplate;
//角色绑定权限
    @RequestMapping("/addRm")
    @Transactional
    @ResponseBody
    public ResponseResult addRm(@RequestBody RoleInfo roleInfo){
        ResponseResult responseResult=new ResponseResult();

        try {
            roleService.addRole(roleInfo);
            String sql1="delete from base_role_menu where roleId=?";
            jdbcTemplate.update(sql1,roleInfo.getId());

            String[] ids = roleInfo.getIds();
            if(ids!=null&&!ids.equals("")) {
                //中间表添加权限
                String sql="insert into base_role_menu(id,roleId,menuId) values(?,?,?)";
                List<Object[]>list=new ArrayList<>();
                TwitterIdWorker twitterIdWorker = new TwitterIdWorker();
                for (String s : ids) {

                    list.add(new Object[]{twitterIdWorker.nextId(),roleInfo.getId(),Long.parseLong(s)});
                }
                jdbcTemplate.batchUpdate(sql,list);
            }

            responseResult.setCode(200);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            responseResult.setCode(500);
        }

        return responseResult;
    }




}