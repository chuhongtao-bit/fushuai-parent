package com.manager.service;

import com.github.pagehelper.PageInfo;
import com.kh.pojo.entity.UserInfo;

public interface UserMapperServer {
    //分页
    PageInfo<UserInfo> selectAll(Integer page, Integer pageSize, String data1, String data2, String sex, String userName);
}
