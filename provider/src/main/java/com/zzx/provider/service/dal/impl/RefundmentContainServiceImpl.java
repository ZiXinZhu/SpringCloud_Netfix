package com.zzx.provider.service.dal.impl;

import com.zzx.provider.dao.RefundmentDOMapper;
import com.zzx.provider.entity.RefundmentDO;
import com.zzx.provider.service.dal.ContainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefundmentContainServiceImpl implements ContainService<RefundmentDO> {


    public RefundmentContainServiceImpl() {
        System.out.println("RefundmentContainServiceImpl��ʼ��");
    }

    @SuppressWarnings("all")
    @Autowired
    private RefundmentDOMapper refundmentDOMapper;

    @Override
    public RefundmentDO lock(int id) {
        return refundmentDOMapper.lock(id);
    }

    @Override
    public int update(RefundmentDO refundmentDO) {
        return refundmentDOMapper.updateByPrimaryKeySelective(refundmentDO);
    }

    @Override
    public int insert(RefundmentDO refundmentDO) {
        return refundmentDOMapper.insertSelective(refundmentDO);
    }
}
