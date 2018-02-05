package com.seax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * 注册
     * 
     * @param user
     * @return
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public Object registerUser(User user) {
        System.out.println("11111");
        List<User> userList = userServiceImpl.select(user);
        System.out.println("22222");
        return userList;
    }
}
