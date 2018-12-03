package com.xudy.tbke.controller;



import com.xudy.tbke.model.Result;
import com.xudy.tbke.model.RespCode;
import com.xudy.tbke.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @RequestMapping(value = "/list")
    public Result selectShop(){
        RespCode resp= new RespCode();
        resp.setCode(0);
        resp.setMsg("ok");
        List<Map<String,Object>> list = shopService.listShop();
    return new Result(resp,list);

    }
}
