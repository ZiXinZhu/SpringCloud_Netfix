package com.zzx.provider.service.dal.impl;


import com.zzx.provider.dao.OrderDOMapper;
import com.zzx.provider.entity.OrderDO;
import com.zzx.provider.entity.dto.OrderDTO;
import com.zzx.provider.service.dal.ContainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderContainServiceImpl implements ContainService<OrderDTO> {


    public OrderContainServiceImpl() {
        System.out.println("OrderContainServiceImpl��ʼ��");
    }

    @SuppressWarnings("all")
    @Autowired
    private OrderDOMapper orderDOMapper;

    @Override
    public OrderDTO lock(int id) {
        return new OrderDTO().convertOrderDOToOrderDTO(orderDOMapper.lock(id));
    }

    @Override
    public int update(OrderDTO orderDTO) {
        return orderDOMapper.updateByPrimaryKeySelective(orderDTO.clone() == null ? new OrderDO() : orderDTO.clone().convertOrderDTOToOrderDO());
    }

    @Override
    public int insert(OrderDTO orderDTO) {
        return orderDOMapper.insertSelective(orderDTO.convertOrderDTOToOrderDO());
    }
}
