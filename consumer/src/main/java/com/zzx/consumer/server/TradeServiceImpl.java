package com.zzx.consumer.server;


import org.springframework.beans.factory.annotation.Autowired;
import com.zzx.commons.entity.dto.OrderDTO;
import com.zzx.commons.templates.CommonResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public CommonResult<OrderDTO> order() {
        return restTemplate.getForObject("http://PROVIDER/order",CommonResult.class);
    }
}
