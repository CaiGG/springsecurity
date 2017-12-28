package com.springsecurity.dao;

import com.springsecurity.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Dao接口
 */
@Repository
public interface UserDao {
    /*@Select("select * FROM user_info where username = #{username}")*/
    public User findByUserName(String username);
}
