package com.zzx.consumer.controller;

import com.zzx.commons.entity.dto.OrderDTO;
import com.zzx.commons.templates.CommonResult;
import com.zzx.consumer.entity.People;
import com.zzx.consumer.entity.UserEntity;
import com.zzx.consumer.server.GirlService;
import com.zzx.consumer.server.TradeServiceImpl;
import com.zzx.consumer.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class TradeController {

    @Autowired
    private TradeServiceImpl tradeService;

    @Autowired
    private GirlService girlService;

    @GetMapping("/orders")
    public CommonResult<OrderDTO> orderResult(){
       return tradeService.order();
    }

    @GetMapping("/test")
    public void addUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(99);
        userEntity.setHigh(99);
        userEntity.setNumber(99);
        girlService.addUser(userEntity);
    }
    @GetMapping("/download")
    public void xlsDownload(HttpServletResponse response) {
        String name = "厕所是按时按.xlsx";
        String[] title = {"姓名","年龄","时间"};
        List<People> list = new ArrayList<>();
        People people = new People();
        people.setName("zzx");
        people.setAge(25);
        people.setTime(new Date());
        list.add(people);
        People people1 = new People();
        people1.setName("lz");
        people1.setAge(1233121212);
        people1.setTime(new Date());
        list.add(people1);
        ExcelUtil.download(response,name,list,title);
    }
}
