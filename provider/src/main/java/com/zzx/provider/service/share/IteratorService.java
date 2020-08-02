package com.zzx.provider.service.share;

import com.zzx.provider.entity.BaseDO;

import java.util.Map;

public interface IteratorService {

    /**
     * 遍历map入库数据
     *
     * @param map
     */
    void mapIterator(Map<String, ? extends BaseDO> map);
}
