package com.xudy.tbke.controller;

import com.xudy.tbke.model.Result;
import com.xudy.tbke.model.RespCode;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class MainsiteErrorController implements ErrorController {


    private static final String ERROR_PATH = "/error";

    @RequestMapping(value="/500")
    public Result handleError(){
        RespCode res = new RespCode();
        res.setMsg("网络异常");
        res.setCode(500);
        return new Result(res);
    }
    
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
