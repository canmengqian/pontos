package com.pontons.drools.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Order
 * @Description TODO
 * @Author zhengzz
 * Date 2021/4/9
 * @Version 1.0.0
 */
@Data
public class Order {
    private Date bookingDate;//下单日期

    private int amout;//订单原价金额

    private User user;//下单人

    private int score;
}
