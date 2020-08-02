package com.zzx.provider.service.share;

import com.zzx.provider.entity.TradeDO;

public interface TradeService {

    /**
     * 回调业务处理
     *
     * @param tradeDO
     * @return
     */
    String process(TradeDO tradeDO);
}
