package com.xudy.tbke.mapper;

import com.xudy.tbke.model.UserGrade;

import java.util.List;
import java.util.Map;

public interface UserGradeMapper {

    public List<Map<String,Object>> selectAll();

    public List<UserGrade> selectById(Integer id);

    public List<UserGrade> selectByPage(Map<String,Object> map);

    public int insertOne(UserGrade userGrade);

    public int insertMore(List<UserGrade> list);

    public int getTotals();
}
