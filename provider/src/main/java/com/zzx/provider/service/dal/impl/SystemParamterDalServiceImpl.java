package com.zzx.provider.service.dal.impl;

import com.zzx.provider.entity.ParameterDO;
import com.zzx.provider.dao.ParameterDOMapper;
import com.zzx.provider.service.dal.SystemParamterDalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemParamterDalServiceImpl implements SystemParamterDalService {

    @Autowired
    private ParameterDOMapper parameterDOMapper;

    @Override
    public ParameterDO getSelectParameter(String keyWord) {
        return parameterDOMapper.getSelectParameter(keyWord);
    }
}
