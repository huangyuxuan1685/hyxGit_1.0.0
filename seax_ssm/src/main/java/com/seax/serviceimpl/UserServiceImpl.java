package com.seax.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seax.dao.UserMapper;
import com.seax.entity.InsideResult;
import com.seax.entity.User;
import com.seax.service.IUserService;
import com.seax.toolset.service.IPasswordEncryption;

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
    private IPasswordEncryption passwordEncryptionImpl;

    @Override
    public Integer insert(User user) {
        Integer insertId = -1;
        // 用户名、密码和昵称不能为空
        if (paramsJudge(user)) {
            return insertId;
        }
        User baseUser = userMapperImpl.selectOneUserByUserName(user);
        // 不能有相同用户名
        if (baseUser != null) {
            return insertId;
        }
        user.setCreatedTime(new Date());

        try {
            InsideResult insideResult = passwordEncryptionImpl.encryptionPassword(null, 32,
                    user.getUserPassword());
            if (insideResult.getSuccess()) {
                Map<String, Object> resultMap = (Map<String, Object>) insideResult.getResultValue();
                String encryptionPassword = (String) resultMap.get("password");
                String salt = (String) resultMap.get("salt");
                String encryptionType = (String) resultMap.get("encryptionType");
                System.out.println(encryptionPassword);

                user.setUserPasswordStr(encryptionPassword);
                user.setEncryptionType(encryptionType);
                user.setSalt(salt);
                insertId = userMapperImpl.insert(user);
            }
        } catch (Exception e) {
            System.out.println("insert user error:" + e);
            insertId = -1;
        }

        return insertId;
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

    @Override
    public Integer check(User user) {

        return null;
    }
}
