package com.xudy.tbke.controller;


import com.xudy.tbke.model.Result;
import com.xudy.tbke.model.RespCode;
import com.xudy.tbke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping(value = "/login")
    public Result login(@RequestBody Map<String, String> person){
        RespCode res = new RespCode();
        res.setCode(0);
        res.setMsg("ok");
        System.out.println("dsadasd");
        return  new Result(res,person);
    }


}
