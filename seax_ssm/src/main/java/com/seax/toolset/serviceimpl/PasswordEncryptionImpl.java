package com.seax.toolset.serviceimpl;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seax.entity.InsideResult;
import com.seax.toolset.service.IPasswordEncryption;
import com.seax.toolset.service.IPasswordMD5Encryption;
import com.seax.toolset.service.IPasswordSHA1Encryption;

/**
 * 
 * 密码加密实现类
 * 
 * @description: TODO 密码加密实现类
 * @author: huangyuxuan
 * @version: 1.0
 * @date: 2018 2018年3月1日 下午5:07:02
 */
@Service
public class PasswordEncryptionImpl implements IPasswordEncryption {

    @Autowired
    private IPasswordMD5Encryption passwordMD5EncryptionImpl;

    @Autowired
    private IPasswordSHA1Encryption passwordSHA1EncryptionImpl;

    @Override
    public InsideResult encryptionPassword(String encryptionType, Integer encryptionNumber,
            char[] password) {
        Map<String, Object> passwordObject = new HashMap<String, Object>();

        // 盐值字符串
        String saltStr = "";
        // 加密后密码
        String encryprionPassword = "";
        // 成功标志位
        boolean encryptionFlag = false;

        if (encryptionType == null || "".equals(encryptionType)) {
            encryptionType = getEncryptionType();
        }
        passwordObject.put("encryptionType", encryptionType);

        // 返回字符串
        String resultMassage = "";
        switch (checkType(encryptionType)) {
            case 0:
                encryptionFlag = false;
                resultMassage = "目前只支持MD5加密和SHA-1加密,请选择正确类型!!!";
                passwordObject = null;
                break;
            case 1:
                saltStr = passwordMD5EncryptionImpl.getSaltStr(16);
                encryprionPassword = passwordMD5EncryptionImpl.getEncryptionPassword(
                        password.toString(), saltStr);
                // 加密后将密码清除
                password = saltStr.toCharArray();
                passwordObject.put("salt", saltStr);
                passwordObject.put("password", encryprionPassword.substring(0, encryptionNumber));

                encryptionFlag = true;
                resultMassage = "md5加密成功";
                break;
            case 2:
                saltStr = passwordSHA1EncryptionImpl.getSaltStr(16);
                encryprionPassword = passwordSHA1EncryptionImpl.getEncryptionPassword(
                        password.toString(), saltStr);

                passwordObject.put("salt", saltStr);
                passwordObject.put("password", encryprionPassword.substring(0, encryptionNumber));

                encryptionFlag = true;
                resultMassage = "SHA-1加密成功";
                break;
            default:
                break;
        }

        // 构建返回值
        InsideResult insideResult = new InsideResult();
        insideResult.setMassage(resultMassage);
        insideResult.setResultValue(passwordObject);
        insideResult.setSuccess(encryptionFlag);
        if (encryptionFlag) {
            insideResult.setStatus(1);
        } else {
            insideResult.setStatus(0);
        }

        return insideResult;
    }

    @Override
    public InsideResult checkPassword(String encryptionType, char[] password, String basePassword,
            String salt) {

        // 成功标志位
        boolean encryptionFlag = false;
        // 返回字符串
        String resultMassage = "";
        switch (checkType(encryptionType)) {
            case 0:
                encryptionFlag = false;
                resultMassage = "目前只支持MD5加密和SHA-1加密,请选择正确类型!!!";
                break;
            case 1:
                if (passwordMD5EncryptionImpl
                        .checkPassword(password.toString(), basePassword, salt)) {
                    resultMassage = "解密成功";
                } else {
                    resultMassage = "解密失败";
                }
                break;
            case 2:
                if (passwordSHA1EncryptionImpl.checkPassword(password.toString(), basePassword,
                        salt)) {
                    resultMassage = "解密成功";
                } else {
                    resultMassage = "解密失败";
                }
                break;
            default:
                break;
        }

        // 构建返回值
        InsideResult insideResult = new InsideResult();
        insideResult.setMassage(resultMassage);
        insideResult.setSuccess(encryptionFlag);
        if (encryptionFlag) {
            insideResult.setStatus(1);
        } else {
            insideResult.setStatus(0);
        }

        return insideResult;
    }

    /**
     * 
     * 判断加密类型
     * 
     * @description: TODO 判断加密类型
     * @author: huangyuxuan
     * @version: 1.0
     * @date: 2018 2018年3月6日 上午9:42:52
     * @param encryptionType 加密类型
     * @return 错误:0; MD5:1; SHA-1:2;
     */
    private Integer checkType(String encryptionType) {
        if ("md5".equals(encryptionType)) {
            return 1;
        } else if ("sha1".equals(encryptionType)) {
            return 2;
        } else {
            return 0;
        }
    }

    private String getEncryptionType() {
        Random random = new Random();
        if (random.nextInt(1000) % 9 < 5) {
            return "md5";
        } else {
            return "sha1";
        }
    }
}
