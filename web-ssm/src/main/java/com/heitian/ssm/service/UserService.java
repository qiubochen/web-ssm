package com.heitian.ssm.service;

import com.heitian.ssm.model.User;

import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public interface    UserService {

    List<User> getAllUser();
    Boolean isHaveUserName(String name);//查看是否有这个用户名用于注册
    Boolean findUserNameToLogin(String name,String password);//找到用户名用于登录
    void addUser(User user);
    User getUserByName(String name);
}
