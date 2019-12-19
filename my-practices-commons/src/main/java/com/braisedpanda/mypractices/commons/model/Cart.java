package com.braisedpanda.mypractices.commons.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: my-practices
 * @description: 我的购物车
 * @author: chenzhen
 * @create: 2019-12-19 11:22
 **/
@Data
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "commodity_id")
    private Integer commodityId;


    @Column(name = "count")
    private Integer count;

    @Column(name = "total")
    private Double total;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "create_time")
    private String createTime;
}
