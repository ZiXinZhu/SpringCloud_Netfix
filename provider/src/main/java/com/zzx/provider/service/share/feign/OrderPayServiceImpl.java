package com.zzx.provider.service.share.feign;

import com.zzx.commons.templates.CommonResult;
import com.zzx.provider.service.share.OrderPayServcie;
import org.springframework.stereotype.Service;

@Service
public class OrderPayServiceImpl implements OrderPayServcie {
    @Override
    public CommonResult<String> ordersList(String param) {
        CommonResult<String> result = new CommonResult<>();
        result.setResult("Provider:"+param);
        result.setSuccess(true);
        return result;
    }
}
