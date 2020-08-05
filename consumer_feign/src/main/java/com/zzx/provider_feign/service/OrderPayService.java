package com.zzx.provider_feign.service;

import com.zzx.commons.templates.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "provider")
public interface OrderPayService {

    @PostMapping("/pay")
    CommonResult<String> ordersList(String param);

}
