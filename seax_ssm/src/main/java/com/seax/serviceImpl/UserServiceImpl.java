package com.seax.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seax.dao.UserMapper;
import com.seax.entity.User;
import com.seax.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapperImpl;

    @Override
    public Integer insert(User user) {
        //        return userMapperImpl.insert(user);
        return null;
    }

    @Override
    public Integer update(User user) {
        //        return userMapperImpl.update(user);
        return null;
    }

    @Override
    public Integer delete(User user) {
        //        return userMapperImpl.delete(user);
        return null;
    }

    @Override
    public List<User> select(User user) {
        return userMapperImpl.select(user);
    }
}
