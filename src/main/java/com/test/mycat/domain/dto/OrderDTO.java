package com.test.mycat.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther: huang
 * @Date: 2019/5/15 11:16
 * @Description:
 */
@Data
public class OrderDTO implements Serializable{


    private BigDecimal amount;


    private Long buyerId;


    private String buerName;


    private Long sellerId;


    private String sellerName;


    private Long productId;

    private String productName;
}