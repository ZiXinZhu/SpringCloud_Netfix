package com.zzx.provider.controller;

import com.zzx.commons.templates.CommonResult;
import com.zzx.commons.templates.ParamterHandler;
import com.zzx.commons.templates.ProcessHandler;
import com.zzx.provider.entity.TradeDO;
import com.zzx.provider.service.share.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("all")
public class TradeController {


    @Autowired
    TradeService tradeService;


    @GetMapping("/transaction")
    public CommonResult<String> process() {
        TradeDO tradeDO = new TradeDO();
        tradeDO.setId(311076);
        tradeDO.setBank("ICBC");
        tradeDO.setRemark("TEST");
        CommonResult<String> result = new CommonResult<>();
        ProcessHandler.handler(result, new ParamterHandler() {
            @Override
            public void check() {
                tradeDO.available();
            }

            @Override
            public void process() {
                result.setResult(tradeService.process(tradeDO));
            }
        });
        return result;
    }
}
