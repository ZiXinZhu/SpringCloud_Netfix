package com.zzx.consumer.server;


import com.zzx.commons.entity.dto.OrderDTO;
import com.zzx.commons.utils.CommonResult;

public interface TradeService {
    CommonResult<OrderDTO> order();
}
