/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserMapperServerImpl
 * Author:   康鸿
 * Date:     2019/8/7 21:35
 * Description: TODO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.manager.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kh.pojo.entity.UserInfo;
import com.manager.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: TODO
 *
 * @author 康鸿
 * @create 2019/8/7
 * @since 1.0.0
 * Description
 */
@Service
public class UserMapperServerImpl implements UserMapperServer {
    @Autowired
    private UserMapper userMapper;

    //分页全查
    public PageInfo<UserInfo> selectAll(Integer page, Integer pageSize, String data1, String data2, String sex ,String userName) {
        PageHelper.startPage(page, pageSize);
        List<UserInfo> list = userMapper.userList(data1, data2, sex,userName);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


}