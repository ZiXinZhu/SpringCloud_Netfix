package com.zzx.provider.service.share;

import com.zzx.provider.entity.dto.OrderDTO;

public interface OrderService {

    /**
     * 下单业务处理
     *
     * @param orderDO
     * @return
     */
    OrderDTO process(OrderDTO orderDO);
}
