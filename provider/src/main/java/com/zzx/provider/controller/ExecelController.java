package com.zzx.provider.controller;


import com.zzx.provider.common.CommonResult;
import com.zzx.provider.common.ParamterHandler;
import com.zzx.provider.common.ProcessHandler;
import com.zzx.provider.utils.ExecelUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ExecelController {

    @GetMapping("/download")
    public void xlsDownload(HttpServletResponse response) {
        ExecelUtil.download(response);
    }

    @PostMapping("/upload")
    public CommonResult<String> readXls(@RequestParam("file") MultipartFile file) {
        CommonResult<String> result = new CommonResult<>();
        ProcessHandler.handler(result, new ParamterHandler() {
            @Override
            public void check() {
            }

            @Override
            public void process() {
                result.setResult(ExecelUtil.upLoadExecel(file));
            }
        });
        return result;
    }
}
