package com.seax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.seax.entity.User;
import com.seax.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userServiceImpl;

    @RequestMapping("/test")
    public String index() {
        System.out.println("testIndex");
        return "/page/index";
    }

    /**
     * 获取用户
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    @ResponseBody
    public Object getUser(User user) {
        System.out.println("11111");
        List<User> userList = userServiceImpl.select(user);
        System.out.println("22222");
        return userList;
    }

    /**
     * 注册
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.POST)
    @ResponseBody
    public Object registerUser(String params) {

        // 解析传入的json，获取参数
        JSONObject json = JSONObject.parseObject(params);

        User user = new User();
        user.setUserName(json.getString("userName"));
        user.setNickName(json.getString("nickName"));
        user.setMobile(json.getString("mobile"));
        user.setUserPassword(json.getString("userPassword").toCharArray());

        System.out.println("22222");
        Integer addFlag = userServiceImpl.insert(user);
        System.out.println(addFlag);
        System.out.println("33333");
        return addFlag;
    }

    /**
     * 校验
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ResponseBody
    public Object checkUser(String params) {
        // 解析传入的json，获取参数
        JSONObject json = JSONObject.parseObject(params);

        User user = new User();

        System.out.println("22222");
        Integer addFlag = userServiceImpl.check(user);
        System.out.println(addFlag);
        System.out.println("33333");
        return addFlag;
    }
}
