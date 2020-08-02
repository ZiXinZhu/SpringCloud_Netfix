package com.zzx.consumer.server;


import com.zzx.commons.entity.dto.OrderDTO;
import com.zzx.commons.templates.CommonResult;

public interface TradeService {
    CommonResult<OrderDTO> order();
}
