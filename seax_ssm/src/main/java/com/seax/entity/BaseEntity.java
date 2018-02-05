package com.seax.entity;

import java.util.Date;

/**
 * 
 * 基本实体类
 * 
 * @description: 基本实体类
 * @author: hyx
 * @date: 2018 2018年2月5日 下午4:50:57
 */
public class BaseEntity {

    /**
     * id
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 创建时间字符串
     */
    private String createdTimeStr;

    /**
     * 创建时间
     */
    private Date modifiedTime;

    /**
     * 创建时间字符串
     */
    private String modifiedTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedTimeStr() {
        return createdTimeStr;
    }

    public void setCreatedTimeStr(String createdTimeStr) {
        this.createdTimeStr = createdTimeStr;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedTimeStr() {
        return modifiedTimeStr;
    }

    public void setModifiedTimeStr(String modifiedTimeStr) {
        this.modifiedTimeStr = modifiedTimeStr;
    }

}
