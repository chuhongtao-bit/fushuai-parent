/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RoleServer
 * Author:   康鸿
 * Date:     2019/8/9 11:01
 * Description: TODO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.manager.service;

import com.kh.pojo.entity.RoleInfo;
import com.manager.dao.MenuDao;
import com.manager.dao.RoleDao;
import com.manager.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: TODO
 *
 * @author 康鸿
 * @create 2019/8/9
 * @since 1.0.0
 * Description
 */
@Service
public class RoleService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleDao roleDao;

    //角色删除
    public int deleteRoleById(Long id) {
        roleDao.deleteById(id);
        return 200;
    }

    //角色添加
    public int addRole(RoleInfo r) {
        roleDao.save(r);
        return 200;
    }

    //角色添加
    public List<RoleInfo> bdrolelist() {
        List<RoleInfo> bdrolelist = roleDao.findAll();
        return bdrolelist;
    }



}