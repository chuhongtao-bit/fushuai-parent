package com.sso.dao;
import	java.util.Queue;

import com.kh.pojo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 */
public interface UserDao extends JpaRepository<UserInfo,Long> {
    @Query(value ="select * from base_user where loginName=?1",nativeQuery =true)
    public UserInfo findByLoginName(String loginName);
}
