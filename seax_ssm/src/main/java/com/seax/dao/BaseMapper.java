package com.seax.dao;

import java.util.List;

/**
 * 
 * 基本库接口类
 * 
 * @description: 基本库接口类
 * @author: hyx
 * @date: 2018 2018年2月5日 下午4:55:37
 */
public interface BaseMapper<T> {

    /**
     * 基本插入方法
     * 
     * @description: 基本插入方法
     * @author: hyx
     * @version: 2.0
     * @date: 2018 2018年2月5日 下午4:56:02
     * @param record
     * @return
     */
    Integer insert(T record);

    /**
     * 基本更新方法
     * 
     * @description: 基本更新方法
     * @author: hyx
     * @version: 2.0
     * @date: 2018 2018年2月5日 下午4:56:02
     * @param record
     * @return
     */
    Integer update(T record);

    /**
     * 基本删除方法
     * 
     * @description: 基本删除方法
     * @author: hyx
     * @version: 2.0
     * @date: 2018 2018年2月5日 下午4:56:02
     * @param record
     * @return
     */
    Integer delete(T record);

    /**
     * 基本查询方法
     * 
     * @description: 基本查询方法
     * @author: hyx
     * @version: 2.0
     * @date: 2018 2018年2月5日 下午4:56:02
     * @param record
     * @return
     */
    List<T> select(T record);
}
