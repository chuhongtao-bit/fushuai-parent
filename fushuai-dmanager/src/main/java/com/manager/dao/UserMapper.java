package com.manager.dao;

import com.kh.pojo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //分页全查
    List<UserInfo> userList(@Param("data1") String data1, @Param("data2") String data2, @Param("sex") String sex, @Param("userName") String userName);
}
