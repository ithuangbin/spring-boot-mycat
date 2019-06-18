package com.test.mycat.controller;

import com.test.mycat.common.PageData;
import com.test.mycat.common.ResponseResult;
import com.test.mycat.domain.dto.OrderDTO;
import com.test.mycat.domain.dto.PageDTO;
import com.test.mycat.domain.vo.OrderVo;
import com.test.mycat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: huang
 * @Date: 2019/5/15 10:21
 * @Description:
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("list")
    public ResponseResult getList(){
        List<OrderVo> list = orderService.getList();
        return ResponseResult.success(list);
    }

    @PostMapping("page")
    public ResponseResult getPg(@RequestBody PageDTO pageDTO){
        PageData<OrderVo> pg = orderService.getUserPage(pageDTO);
        return ResponseResult.success(pg);
    }


    @PostMapping("save")
    public ResponseResult save(@RequestBody OrderDTO userDTO){
        Long id = orderService.save(userDTO);
        return ResponseResult.success(id);
    }

}