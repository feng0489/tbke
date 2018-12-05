package com.xudy.tbke.dao.Impl;

import com.xudy.tbke.dao.UserOrderDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@MapperScan("com.xudy.tbke.dao.Impl")
@SpringBootApplication
@Repository
public class UserOrderDaoImpl implements UserOrderDao {
}
