package com.seax.entity;

/**
 * 用户信息表
 * 
 * @author hyx
 *
 */
public class User extends BaseEntity {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称（或用户姓名）
     */
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 用户密码加密前
     */
    private char[] userPassword;

    /**
     * 用户密码加密后
     */
    private String userPasswordStr;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 加密类型
     */
    private String encryptionType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public char[] getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(char[] userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPasswordStr() {
        return userPasswordStr;
    }

    public void setUserPasswordStr(String userPasswordStr) {
        this.userPasswordStr = userPasswordStr;
    }

    public String getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(String encryptionType) {
        this.encryptionType = encryptionType;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}
