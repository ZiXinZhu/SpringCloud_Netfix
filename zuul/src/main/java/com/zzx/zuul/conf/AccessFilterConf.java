package com.zzx.zuul.conf;

import com.zzx.zuul.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccessFilterConf {
    @Bean
    public AccessFilter filter(){
        return new AccessFilter();
    }
}
