package com.manager.dao;

import com.kh.pojo.entity.RoleInfo;
import com.kh.pojo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {
    //角色分页全查
    List<RoleInfo> roleList(@Param("roleName") String roleName);
}
