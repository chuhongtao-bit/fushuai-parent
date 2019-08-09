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
import com.kh.pojo.entity.RoleInfo;
import com.manager.dao.RoleMapper;
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
public class RoleMapperServerImpl implements RoleMapperServer {
    @Autowired
    private RoleMapper roleMapper;

    //角色列表
    @Override
    public PageInfo<RoleInfo> roleList(Integer page, Integer pageSize, String roleName) {
        PageHelper.startPage(page, pageSize);
        List<RoleInfo> list = roleMapper.roleList(roleName);
        PageInfo<RoleInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}