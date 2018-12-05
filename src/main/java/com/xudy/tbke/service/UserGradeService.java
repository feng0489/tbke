package com.xudy.tbke.service;

import com.xudy.tbke.model.UserGrade;

import java.util.List;
import java.util.Map;

public interface UserGradeService {

    public List<Map<String,Object>> selectAll();

    public List<UserGrade> selectById(Integer id);

    public List<UserGrade> selectByPage(Map<String,Object> map);

    public int getTotal();

    public int insertOne(UserGrade userGrade);

    public int insertMore(List<UserGrade> list);

}
