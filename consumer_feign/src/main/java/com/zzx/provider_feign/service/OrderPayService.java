package com.zzx.provider_feign.service;

import com.zzx.commons.templates.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "provider")
public interface OrderPayService {

    @GetMapping("/pay")
    CommonResult<String> ordersList(@RequestParam("param") String param);

}
