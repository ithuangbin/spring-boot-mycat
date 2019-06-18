package com.test.mycat.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.mycat.annotation.TargetDateSource;
import com.test.mycat.common.PageData;
import com.test.mycat.dao.OrderMapper;
import com.test.mycat.domain.dto.OrderDTO;
import com.test.mycat.domain.dto.PageDTO;
import com.test.mycat.domain.vo.OrderVo;
import com.test.mycat.entity.Order;
import com.test.mycat.entity.OrderExample;
import com.test.mycat.constants.DataSourceKeyConstants;
import com.test.mycat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: huang
 * @Date: 2019/5/15 11:06
 * @Description:
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    @TargetDateSource(DataSourceKeyConstants.SLAVE1)
    public List<OrderVo> getList() {
        OrderExample example = new OrderExample();
        List<Order> orders = orderMapper.selectByExample(example);
        return JSON.parseArray(JSON.toJSONString(orders),OrderVo.class);
    }

    @Override
    public Long save(OrderDTO orderDTO) {
        String jsonString = JSON.toJSONString(orderDTO);
        Order order = JSON.parseObject(jsonString,Order.class);
        order.setOrderNo(UUID.randomUUID().toString());
        order.setOrderStatus(0);
        order.setAddBy(1L);
        order.setAddTime(new Date());
        orderMapper.insert(order);
        return order.getOrderId();
    }

    @Override
    @TargetDateSource(DataSourceKeyConstants.SLAVE1)
    public PageData<OrderVo> getUserPage(PageDTO pageDTO) {
        PageHelper.startPage(null==pageDTO.getCurrent()?1:pageDTO.getCurrent(),null==pageDTO.getPageSize()?10:pageDTO.getPageSize());
        OrderExample example = new OrderExample();
        List<Order> orders = orderMapper.selectByExample(example);
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        PageData<OrderVo> result = new PageData<>();
        result.setCurrent(pageInfo.getPageNum());
        result.setData(JSON.parseArray(JSON.toJSONString(pageInfo.getList()),OrderVo.class));
        result.setTotal(pageInfo.getTotal());
        result.setPageSize(pageInfo.getPageSize());
        return result;
    }
}