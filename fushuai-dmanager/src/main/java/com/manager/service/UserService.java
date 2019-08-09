/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserService
 * Author:   康鸿
 * Date:     2019/8/5 19:31
 * Description: TODO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.manager.service;

import com.kh.pojo.entity.MenuInfo;
import com.kh.pojo.entity.RoleInfo;
import com.kh.pojo.entity.UserInfo;

import com.manager.dao.MenuDao;
import com.manager.dao.RoleDao;
import com.manager.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Description: TODO
 *
 * @author 康鸿
 * @create 2019/8/5
 * @since 1.0.0
 * Description
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RoleDao roleDao;


    //通过id删除
    public int deleteUserById(Long id) {
        userDao.deleteById(id);
        return 200;
    }

    //增加
    public int addUser(UserInfo userInfo){
        userDao.save(userInfo);
        return 200;
    }

    //修改
    public int updateUser(UserInfo userInfo){
        userDao.save(userInfo);
        return 200;
    }

}