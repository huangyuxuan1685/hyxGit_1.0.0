package com.seax.dao;

import com.seax.entity.User;

/**
 * 
 * 用户库接口
 * 
 * @description: 与用户库进行交互
 * @author: hyx
 * @date: 2018 2018年2月5日 下午4:57:46
 */
public interface UserMapper extends BaseMapper<User> {


    /**
     * 
     * 查询一个用户
     * 
     * @description: TODO 用于新增的用户查询,新增传入用户名判断
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年2月28日 下午4:21:07
     * @param user
     * @return
     */
    User selectOneUserByUserName(User user);

}
