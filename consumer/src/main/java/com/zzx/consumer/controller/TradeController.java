package com.zzx.consumer.controller;

import com.zzx.commons.entity.dto.OrderDTO;
import com.zzx.commons.utils.CommonResult;
import com.zzx.consumer.server.TradeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

    @Autowired
    private TradeServiceImpl tradeService;

    @GetMapping("/orders")
    public CommonResult<OrderDTO> orderResult(){
       return tradeService.order();
    }
}
