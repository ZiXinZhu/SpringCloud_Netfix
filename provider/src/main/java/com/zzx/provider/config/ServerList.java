package com.zzx.provider.config;


import com.zzx.provider.entity.BaseDO;
import com.zzx.provider.enums.ContainEnum;
import com.zzx.provider.service.dal.ContainService;


public class ServerList {

    /**
     * ö�ٱ�ʾbean����
     */
    private ContainEnum containEnum;

    /**
     * �����ӿڶ�Ӧ����ʵ�ֵ�bean
     */
    private ContainService<BaseDO> containService;

    public ServerList() {
        System.out.println("ServerList��ʼ��");
    }


    public ContainEnum getContainEnum() {
        return containEnum;
    }

    public void setContainEnum(ContainEnum containEnum) {
        this.containEnum = containEnum;
    }

    public ContainService<BaseDO> getContainService() {
        return containService;
    }

    public void setContainService(ContainService<BaseDO> containService) {
        this.containService = containService;
    }
}
