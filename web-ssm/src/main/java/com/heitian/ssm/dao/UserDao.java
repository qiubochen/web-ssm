package com.heitian.ssm.dao;

import com.heitian.ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Repository
public interface UserDao {

    User selectUserByName(@Param("name") String name);
    String selectUserName(@Param("name") String name);//注册时通过名字判断是否重复
    void addUser(User user);
    User findUserNameToLogin(@Param("name") String name);
    List<User> selectAllUser();
}
