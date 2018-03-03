package com.seax.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seax.dao.UserMapper;
import com.seax.entity.User;
import com.seax.service.IUserService;
import com.seax.toolset.service.IPasswordMD5Encryption;
import com.seax.toolset.service.IPasswordSHA1Encryption;
import com.seax.toolset.serviceimpl.PasswordMD5EncryptionImpl;
import com.seax.toolset.serviceimpl.PasswordSHA1EncryptionImpl;

/**
 * 
 * 用户接口实现类
 * 
 * @description: TODO 实现用户接口
 * @author: huangyuxuan
 * @version: 1.0
 * @date: 2018 2018年3月1日 上午9:38:47
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapperImpl;

    @Autowired
    private IPasswordMD5Encryption passwordMD5EncryptionImpl;

    @Autowired
    private IPasswordSHA1Encryption passwordSHA1EncryptionImpl;

    @Override
    public Integer insert(User user) {
        // 用户名、密码和昵称不能为空
        if (paramsJudge(user)) {
            return 0;
        }
        User baseUser = userMapperImpl.selectOneUserByUserName(user);
        // 不能有相同用户名
        if (baseUser != null) {
            return 0;
        }
        user.setCreatedTime(new Date());

        return userMapperImpl.insert(user);
    }

    @Override
    public Integer update(User user) {
        paramsJudge(user);
        // return userMapperImpl.update(user);
        return null;
    }

    @Override
    public Integer delete(User user) {
        // return userMapperImpl.delete(user);
        return null;
    }

    @Override
    public List<User> select(User user) {
        List<User> userList = new ArrayList<User>();

        try {
            userList = userMapperImpl.select(user);
        } catch (Exception e) {
            System.out.println(e);
        }

        return userList;
    }

    @Test
    public void passwordTestEncryption() {
        char[] password = { 'a', 'b', 'c', 'd', '1', '2', '3', '4' };

        passwordMD5EncryptionImpl = new PasswordMD5EncryptionImpl();
        passwordSHA1EncryptionImpl = new PasswordSHA1EncryptionImpl();

        String saltStr = passwordMD5EncryptionImpl.getSaltStr(16);
        String md5EPassword = passwordMD5EncryptionImpl.getEncryptionPassword(password.toString(),
                saltStr);
        System.out.println("md5密码: " + md5EPassword);
        String sha1EPassword = passwordSHA1EncryptionImpl.getEncryptionPassword(
                password.toString(), saltStr);
        System.out.println("sha1密码: " + sha1EPassword);
        System.out.println("盐值: " + saltStr);

        boolean checkMD5 = passwordMD5EncryptionImpl.checkPassword(password.toString(),
                md5EPassword);
        if (checkMD5) {
            System.out.println("same");
        } else {
            System.out.println("different");
        }

        boolean checkSHA1 = passwordSHA1EncryptionImpl.checkPassword(password.toString(),
                md5EPassword);
        if (checkSHA1) {
            System.out.println("same");
        } else {
            System.out.println("different");
        }
    }

    /**
     * 非空判断
     * 
     * @description: 非空判断
     * @author: hyx
     * @version: 2.0
     * @date: 2018 2018年2月12日 上午11:25:02
     * @param record
     * @return true空;false非空
     */
    private static Boolean paramsJudge(User user) {
        if (user.getUserName() == null || "".equals(user.getUserName())) {
            return true;
        }
        if (user.getUserPassword() == null || "".equals(user.getUserPassword())) {
            return true;
        }
        if (user.getNickName() == null || "".equals(user.getNickName())) {
            return true;
        }
        return false;
    }
}
