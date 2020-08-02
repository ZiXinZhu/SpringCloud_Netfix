package com.zzx.provider.service.dal;

import com.zzx.provider.entity.TradeDO;

public interface TradeDalService {

    int insertOne(TradeDO tradeDO);

    int updateBank(String bank, int id);

    TradeDO queryOne(int id);

    int updateRemark(String remark, int id);
}
