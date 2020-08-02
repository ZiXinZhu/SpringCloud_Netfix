package com.zzx.provider.controller;

import com.zzx.provider.config.ParamterDRMConfig;
import com.zzx.commons.templates.CommonResult;
import com.zzx.commons.templates.ParamterHandler;
import com.zzx.commons.templates.ProcessHandler;
import com.zzx.provider.exceptions.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/drm")
public class ParamterDRMController {


    @Autowired
    ParamterDRMConfig paramterDRMConfig;

    @GetMapping("/old/list")
    public CommonResult<String> setOldListOU(String list) {
        CommonResult<String> result = new CommonResult<>();
        ProcessHandler.handler(result, new ParamterHandler() {
            @Override
            public void check() {
                if (Objects.isNull(list)) {
                    throw new CommonException("DRM��OU���ò���Ϊ�գ�");
                }
            }

            @Override
            public void process() {
                paramterDRMConfig.setOldListOU(list);
                result.setResult("�ɹ�");
                result.setDescribe("��OU�б��������Ϊ��" + list);
            }
        });
        return result;
    }
}
