package com.xudy.tbke.controller;

import com.xudy.tbke.model.RespCode;
import com.xudy.tbke.model.Result;
import com.xudy.tbke.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userOrder")
public class UserOrderController {

    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping("/list")
    public Result list(){
        List<Map<String,Object>> list = userOrderService.selectAll();
        RespCode resp = new RespCode();
        resp.setMsg("mst");
        resp.setCode(2);
        return new Result(resp,list);
    }

}
