package com.xudy.tbke.controller;

import com.xudy.tbke.model.RespCode;
import com.xudy.tbke.model.Result;
import com.xudy.tbke.service.TradeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tradeLog")
public class TradeLogController {

    @Autowired
    private TradeLogService tradeLogService;

    @RequestMapping("/list")
    public Result list(){
        List<Map<String,Object>> list = tradeLogService.selectAll();
        RespCode resp= new RespCode();
        resp.setCode(0);
        resp.setMsg("ok");
        return new Result(resp,list);
    }

}
