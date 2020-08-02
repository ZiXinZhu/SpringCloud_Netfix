package com.zzx.provider.service.share.impl;

import com.zzx.provider.config.ParamterDRMConfig;
import com.zzx.provider.service.share.SystemParamterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemParamterServiceImpl implements SystemParamterService {

    @Autowired
    private ParamterDRMConfig paramterDRMConfig;

    @Override
    public boolean getSelectParamter(String key) {
        return paramterDRMConfig.getSelectParamter(key);
    }
}
