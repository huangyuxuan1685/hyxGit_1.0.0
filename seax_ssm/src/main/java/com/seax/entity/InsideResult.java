package com.seax.entity;

import java.util.Date;

/**
 * 
 * 内部返回值类
 * 
 * @description: 内部返回值类
 * @author: huangyuxuan
 * @version: 1.0
 * @date: 2018 2018年3月6日 上午9:22:35
 */
public class InsideResult {

    /**
     * 是否成功，成功true，失败false
     */
    private Boolean success;

    /**
     * 状态标志，默认0为false；1为true，可额外指定其他值，但需要约定好
     */
    private Integer status;

    /**
     * 提示语句
     */
    private String massage;

    /**
     * 返回值
     */
    private Object resultValue;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Object getResultValue() {
        return resultValue;
    }

    public void setResultValue(Object resultValue) {
        this.resultValue = resultValue;
    }

}
