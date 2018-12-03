package com.xudy.tbke.service;


import com.xudy.tbke.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<Map<String,Object>> listUser();

    int insertUser(User user);

    List<User> findUserById(int id);
}
