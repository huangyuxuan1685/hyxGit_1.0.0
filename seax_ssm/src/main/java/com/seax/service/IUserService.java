package com.seax.service;

import java.util.List;

import com.seax.entity.User;

/**
 * 
 * 用户服务接口
 * 
 * @description: 用户controller调用用于服务的方法
 * @author: hyx
 * @date: 2018 2018年2月5日 下午4:59:42
 */
public interface IUserService {

    /**
     * 用户插入方法
     * 
     * @description: 用户插入方法
     * @author: hyx
     * @version: 2.0
     * @date: 2018 2018年2月5日 下午4:56:02
     * @param record
     * @return
     */
    Integer insert(User user);

    /**
     * 用户更新方法
     * 
     * @description: 用户更新方法
     * @author: hyx
     * @version: 2.0
     * @date: 2018 2018年2月5日 下午4:56:02
     * @param record
     * @return
     */
    Integer update(User user);

    /**
     * 用户删除方法
     * 
     * @description: 用户删除方法
     * @author: hyx
     * @version: 2.0
     * @date: 2018 2018年2月5日 下午4:56:02
     * @param record
     * @return
     */
    Integer delete(User user);

    /**
     * 用户查询方法
     * 
     * @description: 用户查询方法
     * @author: hyx
     * @version: 2.0
     * @date: 2018 2018年2月5日 下午4:56:02
     * @param record
     * @return
     */
    List<User> select(User user);
    
    /**
     * 
     * (方法名称)
     * @description: TODO (简单说明如何使用，以及其它有助于快速、正确使用它的有关信息)
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年3月6日 下午3:15:31
     * @param user
     * @return
     */
    Integer check(User user);
}
