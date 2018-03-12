package com.seax.toolset.service;

/**
 * 
 * 密码加密接口
 * 
 * @description: TODO 密码加密接口
 * @author: huangyuxuan
 * @version: 1.0
 * @date: 2018 2018年3月1日 下午4:58:33
 */
public interface IPasswordMD5Encryption {

    /**
     * 
     * 获取加密盐值
     * 
     * @description: TODO 传入指定长度，获取指定长度的加密盐值
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年3月1日 下午4:58:29
     * @param length
     * @return
     */
    String getSaltStr(int length);

    /**
     * 
     * 将密码加密
     * 
     * @description: TODO 传入密码和盐值进行加密
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年3月1日 下午5:00:49
     * @param password
     * @param saltStr
     * @return
     */
    String getEncryptionPassword(String password, String saltStr);

    /**
     * 
     * 密码校验
     * 
     * @description: TODO 输入密码与库中密码进行校验
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年3月1日 下午5:01:49
     * @param putInPassword 输入密码
     * @param getBasePassword 库中密码
     * @return
     */
    boolean checkPassword(String putInPassword, String getBasePassword, String salt);
}
