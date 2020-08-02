package com.zzx.provider.controller;

import com.zzx.provider.service.share.OrderService;
import com.zzx.commons.templates.CommonResult;
import com.zzx.commons.templates.ParamterHandler;
import com.zzx.commons.templates.ProcessHandler;
import com.zzx.provider.entity.dto.OrderDTO;
import com.zzx.provider.enums.ContainEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@SuppressWarnings("all")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public CommonResult<OrderDTO> order() {
        OrderDTO orderDO = new OrderDTO();
        orderDO.setId(1);
        orderDO.setUserId(1);
        orderDO.setOrderId("202004050000000012344322");
        orderDO.setMoney("998");
        orderDO.setGoods("phone");
        orderDO.setContainEnum(ContainEnum.ORDER);
        CommonResult<OrderDTO> result = new CommonResult<>();
        ProcessHandler.handler(result, new ParamterHandler() {
            @Override
            public void check() {
                orderDO.available();
            }

            @Override
            public void process() {
                result.setResult(orderService.process(orderDO));
            }
        });
        return result;
    }
}
