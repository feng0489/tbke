package com.xudy.tbke.controller;


import com.xudy.tbke.model.RespCode;
import com.xudy.tbke.model.Result;
import com.xudy.tbke.service.UserGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userGrade")
public class UserGradeController {

    @Autowired
    private UserGradeService userGradeService;

    @RequestMapping("/list")
    public Result list(){
        List<Map<String,Object>> list = userGradeService.selectAll();
        RespCode resp = new RespCode();
        resp.setCode(2);
        resp.setMsg("msg");
        return new Result(resp,list);
    }

}
