package com.heitian.ssm.controller;

import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import com.alibaba.fastjson.*;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    private int STRING_LENGTH=45;
    private Logger log = Logger.getLogger(UserController.class);
    private String STATUS="status";
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("asd","asd");
        jsonObject.put("qw","sad");
        jsonObject.put("sa","ccc");
        System.out.println("jsonobject"+jsonObject.toJSONString());
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        //todo 返回json数据
        return "showUser";
    }

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public @ResponseBody
    JSONObject login(@RequestBody User user){
        //todo  去掉println
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        JSONObject jsonObject = new JSONObject();

        //todo 45
        if(user.getPassword().length()>STRING_LENGTH){
            jsonObject.put(STATUS,10000);
            return jsonObject;
        }
        if(userService.findUserNameToLogin(user.getName(),user.getPassword())){
            jsonObject.put(STATUS,200);

            return jsonObject;
        }
        else {
            jsonObject.put(STATUS,10001);
            return jsonObject;
        }



    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody
    JSONObject register(@RequestBody User user){
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        JSONObject jsonObject=new JSONObject();
        if(user.getPassword().length()>STRING_LENGTH){
            jsonObject.put(STATUS,10000);
            return jsonObject;
        }
        if(userService.isHaveUserName(user.getName())){
            jsonObject.put(STATUS,10002);
            return jsonObject;
        }else{
            userService.addUser(user);
            jsonObject.put(STATUS,200);
            return jsonObject;
        }
    }

}
