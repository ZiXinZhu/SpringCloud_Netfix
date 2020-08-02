package com.zzx.provider.config;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.zzx.provider.entity.ParameterDO;
import com.zzx.provider.service.dal.SystemParamterDalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Component
public class ParamterDRMConfig {

    @SuppressWarnings("all")
    @Autowired
    private SystemParamterDalService systemParamterDalService;

    private LoadingCache<String, ParameterDO> systemParameterCaches;

    /**
     * ��OU�б�
     */
    private String oldListOU = "B01,B02,B03,B04";
    /**
     * ��OU�б�
     */
    private String cloudListOU = "A01,A03,B01,B03";
    /**
     * ����OU�б�
     */
    private String unCloldListOU = "A02,A04,B02,B04";


    @PostConstruct
    public void getSelectParameter() throws ExecutionException, InterruptedException {
        //����ӿ�������LoadingCache��LoadingCache�ڻ��������ʱ�����Զ����ػ���
        systemParameterCaches
                //CacheBuilder�Ĺ��캯����˽�еģ�ֻ��ͨ���侲̬����newBuilder()�����CacheBuilder��ʵ��
                = CacheBuilder.newBuilder()
                //���ò�������Ϊ8������������ָ����ͬʱд������߳���
                .concurrencyLevel(8)
                //����д�����8���ӹ���
                .expireAfterWrite(8, TimeUnit.SECONDS)
                //���û��������ĳ�ʼ����Ϊ10
                .initialCapacity(10)
                //���û����������Ϊ100������100֮��ͻᰴ��LRU�������ʹ���㷨���Ƴ�������
                .maximumSize(100)
                //����Ҫͳ�ƻ����������
                .recordStats()
                //���û�����Ƴ�֪ͨ
                .removalListener(notification -> System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause()))
                //build�����п���ָ��CacheLoader���ڻ��治����ʱͨ��CacheLoader��ʵ���Զ����ػ���
                .build(
                        new CacheLoader<String, ParameterDO>() {
                            @Override
                            public ParameterDO load(String key) throws Exception {
                                ParameterDO parameterDO = systemParamterDalService.getSelectParameter(key);
                                return Objects.nonNull(parameterDO) ? parameterDO : new ParameterDO();
                            }
                        }
                );
    }


    public boolean getSelectParamter(String key) {
        System.out.println("cache stats:");
        //����ӡ����������ʵ� ���
        System.out.println(systemParameterCaches.stats().toString());
        try {
            ParameterDO parameterDO = systemParameterCaches.get(key);
            return !parameterDO.valuesIsNull() && Boolean.parseBoolean(parameterDO.getResultValue());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getOldListOU(int index) {
        return getOne(oldListOU, index);
    }

    /**
     * �޸���OU����
     *
     * @param oldListOU
     */
    public void setOldListOU(String oldListOU) {
        this.oldListOU = oldListOU;
    }

    public String getCloudListOU(int index) {
        return getOne(cloudListOU, index);
    }

    /**
     * �޸���OU����
     *
     * @param cloudListOU
     */
    public void setCloudListOU(String cloudListOU) {
        this.cloudListOU = cloudListOU;
    }

    public String getUnCloldListOU(int index) {
        return getOne(unCloldListOU, index);
    }

    /**
     * �޸ķ���OU����
     *
     * @param unCloldListOU
     */
    public void setUnCloldListOU(String unCloldListOU) {
        this.unCloldListOU = unCloldListOU;
    }

    public String getOne(String ou, int index) {
        String[] split = ou.split(",");
        if (index > split.length - 1) {
            return "error";
        }
        return split[index];
    }
}
