package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.UserDao;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import com.heitian.ssm.utils.Md5Encipher;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private Logger log= Logger.getLogger(UserServiceImpl.class);
    @Resource
    private UserDao userDao;

    public User getUserByName(String name) {
        return userDao.selectUserByName(name);
    }

    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }


    public void addUser(User user) {
        Md5Encipher md5Enciphe=new Md5Encipher();
        try {
            user.setPassword(md5Enciphe.encodeString(user.getPassword()));
            System.out.println("用户名"+user.getName());
            System.out.println("密码"+user.getPassword());
        } catch (NoSuchAlgorithmException e) {
            log.error("md5加密失败");
            e.printStackTrace();
        }
        userDao.addUser(user);
    }

    //todo
    public Boolean isHaveUserName(String name){
        //todo 合在一起
        String sqlName =userDao.selectUserName(name);
        System.out.println("isHaveUserName+用户名"+name);
        //todo StringUtils.isEmpty(sqlName);
        if(sqlName==null)
            return false;
        else
            return true;
    }

    public Boolean findUserNameToLogin(String name,String password) {
        Md5Encipher md5Encipher=new Md5Encipher();
        try {
            password=md5Encipher.encodeString(password);
        } catch (NoSuchAlgorithmException e) {
            log.error("md5加密失败");
            //todo LOG 打印
            e.printStackTrace();
        }
        User user;
        user=userDao.findUserNameToLogin(name);
        // todo {}
        if(user==null) {
            return false;
        }
        //todo 去掉else
        if(user.getPassword().equals(password)) {
            return true;
        }
        // todo 去掉else
            return false;
    }
}
