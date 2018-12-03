package com.xudy.tbke.dao.Impl;


import com.xudy.tbke.dao.UserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;


// MyBatis 支持
//@MapperScan("cn.group.xudy.model.dao.Impl")
@MapperScan("com.xudy.tbke.dao.Impl")
@SpringBootApplication
@Repository
public class UserDaoImpl implements UserDao {
//    @Override
//    public List<CollectionVo> findAllUser() {
//        return null;
//    }
//
//    @Override
//    public List<CollectionVo> findUserById(int id) {
//        return null;
//    }
//
//    @Override
//    public int insertUser(User user) {
//        return 0;
//    }
//
//    @Override
//    public int updateUserByid(User user) {
//        return 0;
//    }
}
