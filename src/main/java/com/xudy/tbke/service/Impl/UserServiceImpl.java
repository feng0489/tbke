package com.xudy.tbke.service.Impl;




import com.xudy.tbke.dao.UserDao;
import com.xudy.tbke.mapper.UserMapper;
import com.xudy.tbke.model.User;
import com.xudy.tbke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<Map<String, Object>> listUser() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> findUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }
}
