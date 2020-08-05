package com.zzx.provider_feign.controlle;

import com.zzx.commons.templates.CommonResult;

import com.zzx.provider_feign.service.OrderPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderPayController {

    @Autowired
    private OrderPayService orderService;

    @GetMapping("/order")
    public CommonResult<String> order(String param){
        return orderService.ordersList(param);
    }
}
