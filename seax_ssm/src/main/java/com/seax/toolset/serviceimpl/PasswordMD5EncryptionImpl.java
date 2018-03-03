package com.seax.toolset.serviceimpl;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import com.seax.toolset.service.IPasswordMD5Encryption;

/**
 * 
 * 密码加密实现类
 * 
 * @description: TODO 密码加密实现类
 * @author: huangyuxuan
 * @version: 1.0
 * @date: 2018 2018年3月1日 下午5:07:02
 */
public class PasswordMD5EncryptionImpl implements IPasswordMD5Encryption {

    /**
     * 盐池
     */
    private static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 加密间隔,即大致要在原始密码的某个部分添加盐值
     */
    private static final Integer ENCRYPTION_INTERVAL = 2;

    /**
     * 加密次数
     */
    private static final Integer ENCRYPTION_Number = 2000;

    @Test
    public void test() {
        //        long d1 = System.currentTimeMillis();
        // 获取盐值(16位)
        String saltStr = getSaltStr(16);
        System.out.println("saltStr从盐池中取盐:" + saltStr);
        //        char[] ar = { 'a', 'b', 'c', 'd', '1', '2', '3', '4' };
        String ar = "abcd1234";

        // 密码加密
        String encryptPwd = getEncryptionPassword(ar, saltStr);
        System.out.println("encryptPwd加密密码:" + encryptPwd);

        String passwordSalt = getSaltByPassword(encryptPwd);
        System.out.println("passwordSalt从密码中取盐:" + passwordSalt);

        if (checkPassword(ar, encryptPwd)) {
            System.out.println("same");
        } else {
            System.out.println("different");
        }
    }
    /**
     * 
     * 从盐池中获取盐值（随机字段）
     * 
     * @description: TODO 根据传入参数，获取指定长度盐值(随机字段), 一般用于新增或修改密码
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年3月1日 上午9:33:07
     * @param length 要获取的长度
     * @return
     */
    @Override
    public String getSaltStr(int length) {
        StringBuffer strBuffer = new StringBuffer(length);
        Random random = new Random();
        // 盐池总长度
        int allCharLength = ALLCHAR.length();
        // 构建盐值
        for (int i = 0; i < length; i++) {
            int randomNumber = random.nextInt(allCharLength);
            strBuffer.append(ALLCHAR.charAt(randomNumber));
        }
        return strBuffer.toString();
    }

    /**
     * 
     * 从密码中取出盐值
     * 
     * @description: TODO 从密码中取出盐值, 一般用于密码校验
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年3月1日 下午2:11:57
     * @param password
     * @return
     */
    public static String getSaltByPassword(String password) {
        try {
            int saltLength = 0;
            if (password.length() % ENCRYPTION_INTERVAL == 0) {
                saltLength = password.length() / ENCRYPTION_INTERVAL;
            } else {
                saltLength = password.length() / ENCRYPTION_INTERVAL + 1;
            }
            // 存储从密码中取出的盐值
            StringBuffer salfStr = new StringBuffer(saltLength);

            for (int i = 0; i < saltLength; i++) {
                salfStr.append(password.charAt(i * ENCRYPTION_INTERVAL + 1));
            }
            return salfStr.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 
     * 将密码加密
     * 
     * @description: TODO 传入密码和盐值进行加密
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年2月28日 下午5:15:54
     * @param password
     * @param saltStr
     * @return
     */
    @Override
    public String getEncryptionPassword(String password, String saltStr) {
        String encryptPwd = "";
        for (int i = 0; i < ENCRYPTION_Number; i++) {
            encryptPwd = encryptionPassword(password.toString(), saltStr);
            encryptPwd = md5Hex(encryptPwd);
            encryptPwd = encryptionPassword(encryptPwd, saltStr);
        }
        return encryptPwd;
    }

    /**
     * 
     * 获取十六进制字符串形式的MD5摘要 16位
     * 
     * @description: TODO 获取十六进制字符串形式的MD5摘要 16位
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年3月1日 下午4:35:06
     * @param src
     * @return
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs)).substring(8, 24);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 
     * 密码加密
     * 
     * @description: TODO 将密码与盐值进行合并成32位密码
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年3月1日 下午4:34:08
     * @param putInPassword 输入的密码
     * @param salt 盐值
     * @return 加密后密码
     */
    public static String encryptionPassword(String putInPassword, String salt) {
        if (putInPassword != null && !"".equals(putInPassword)) {
            StringBuffer sb = new StringBuffer(32);
            // 获取原密码
            sb.append(putInPassword);

            int len = putInPassword.length();
            // 原密码上限长度16不满16位追加0到16位
            final int passwordLimit = 16;
            if (len < passwordLimit) {
                for (int i = 0; i < passwordLimit - len; i++) {
                    sb.append('0');
                }
            }

            // 获取16位原密码
            String salf = sb.toString();
            // 加密密码上限32位
            final int maxLoop = 32;
            // 存储构建后密码数组
            char[] salfArr = new char[maxLoop];
            // 密码重构成32位加密密码
            for (int i = 0; i < maxLoop; i += ENCRYPTION_INTERVAL) {
                char c = salt.charAt(i / ENCRYPTION_INTERVAL);
                salfArr[i] = salf.charAt(i / ENCRYPTION_INTERVAL);
                salfArr[i + 1] = c;
            }
            return new String(salfArr);
        }
        return null;
    }

    /**
     * 
     * 判断密码
     * 
     * @param putInPassword 用户输入密码
     * @param getBasePassword 获取库内密码
     * @param salt 盐值
     * @return true正确,false错误
     * */
    @Override
    public boolean checkPassword(String putInPassword, String getBasePassword) {
        // 非空判断
        boolean flag = (putInPassword != null && !"".equals(putInPassword))
                && (getBasePassword != null && !"".equals(getBasePassword));
        if (flag) {
            // 根据库内密码获取盐值
            String getSaltStrByPassword = getSaltByPassword(getBasePassword);
            // 获取加密用户输入密码,用于校验
            String putPwd = getEncryptionPassword(putInPassword, getSaltStrByPassword);
            // 判断用户输入密码与库内密码是否一致
            if (getBasePassword.equals(putPwd)) {
                return true;
            }
        }
        return false;
    }
}
