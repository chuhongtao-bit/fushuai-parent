package com.manager.dao;

import com.kh.pojo.entity.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 根据用户id获取角色
 */
public interface RoleDao extends JpaRepository<RoleInfo, Long> {

    @Query(value = "select * from base_user_role bur inner join base_role br on bur.roleId=br.id where bur.userId=?1", nativeQuery = true)
    public RoleInfo getRoleInfoByUserId(Long userId);

}
