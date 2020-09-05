package com.zzx.provider_feign.config;

import com.zzx.provider_feign.service.OrderPayService;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetry(){
        // period=100 发起当前请求的时间间隔，单位毫秒
        // maxPeriod=1000 发起当前请求的最大时间间隔，单位毫秒
        // maxAttempts=1 最多请求次数，包括第一次
       return new Retryer.Default(100,1000,2);

    }
}
