package com.zzx.provider.controller;

import com.zzx.commons.templates.CommonResult;
import com.zzx.commons.templates.ParamterHandler;
import com.zzx.commons.templates.ProcessHandler;
import com.zzx.provider.entity.RefundmentDO;
import com.zzx.provider.service.share.RefundmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("all")
public class RefundmentController {
    @Autowired
    RefundmentService refundmentService;

    @GetMapping("/refund")
    public CommonResult<RefundmentDO> refundment(RefundmentDO refundmentDO) {
        CommonResult<RefundmentDO> result = new CommonResult<>();
        ProcessHandler.handler(result, new ParamterHandler() {
            @Override
            public void check() {
                refundmentDO.available();
            }

            @Override
            public void process() {
                result.setResult(refundmentService.process(refundmentDO));
            }
        });
        return result;
    }
}
