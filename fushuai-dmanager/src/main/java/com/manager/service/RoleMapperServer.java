package com.manager.service;

import com.github.pagehelper.PageInfo;
import com.kh.pojo.entity.RoleInfo;

public interface RoleMapperServer {
    //分页
    PageInfo<RoleInfo> roleList(Integer page, Integer pageSize, String rolerName);
}
