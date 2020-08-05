package com.zzx.provider.controller;


import com.zzx.commons.templates.CommonResult;
import com.zzx.provider.service.share.OrderPayServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private OrderPayServcie orderPayServcie;

    @PostMapping("/pay")
    public CommonResult<String> OrderPay(String param){
        return orderPayServcie.ordersList(param);
    }
}
