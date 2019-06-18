package com.test.mycat.service;

import com.test.mycat.common.PageData;
import com.test.mycat.domain.dto.PageDTO;
import com.test.mycat.domain.dto.OrderDTO;
import com.test.mycat.domain.vo.OrderVo;

import java.util.List;

/**
 * @Auther: huang
 * @Date: 2019/5/15 11:06
 * @Description:
 */
public interface OrderService {

    List<OrderVo>  getList();

    Long save(OrderDTO userDTO);

    PageData<OrderVo> getUserPage(PageDTO pageDTO);
}