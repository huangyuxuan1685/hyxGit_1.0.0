package com.seax.toolset.service;

import java.util.Map;

import com.seax.entity.InsideResult;

/**
 * 
 * 密码加密接口
 * 
 * @description: TODO 密码加密接口
 * @author: huangyuxuan
 * @version: 1.0
 * @date: 2018 2018年3月1日 下午4:58:33
 */
public interface IPasswordEncryption {

    /**
     * 
     * 密码加密
     * 
     * @description: TODO 设定加密类型，加密长度
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年3月5日 下午6:02:43
     * @param encryptionType 加密类型，默认MD5加密。 可选类型 ：md5 -> MD5加密; sha1 ->
     *        sha-1加密
     * @param encryptionNumber 要返回的密码长度
     * @return
     */
    InsideResult encryptionPassword(String encryptionType, Integer encryptionNumber, char[] password);

    /**
     * 
     * 密码校验
     * 
     * @description: 将输入密码和库内密码进行校验
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年3月6日 上午9:29:17
     * @param password 输入密码
     * @param basePassword 库内密码
     * @return
     */
    InsideResult checkPassword(String encryptionType, char[] password, String basePassword, String salt);
}
