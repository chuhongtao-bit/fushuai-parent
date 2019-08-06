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
package com.sso.service;

import com.kh.pojo.entity.UserInfo;
import com.sso.dao.UserDao;
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

    public UserInfo getUserByLogin(String loginName){
        //获取用户信息
        UserInfo byLoginName = userDao.findByLoginName(loginName);

        return byLoginName;
    }
}