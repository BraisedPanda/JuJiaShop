package com.braisedpanda.mypractices.commons.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: my-practices
 * @description:  商品类
 * @author: chenzhen
 * @create: 2019-12-18 16:29
 **/
@Data
@Table(name="commodity")
public class Commodity {
    @Id
    @Column(name="id")
    private Integer id;
    @Column(name="cname")
    private String cname;
    @Column(name="price")
    private Double price;
    @Column(name="image1")
    private String image1;
    @Column(name="image2")
    private String image2;
    @Column(name="image3")
    private String image3;
    @Column(name="image4")
    private String image4;
    @Column(name="image5")
    private String image5;
    @Column(name="cid")
    private Integer cid;
    @Column(name="create_time")
    private String createTime;
    @Column(name="sold")
    private Integer sold;
    @Column(name="remainder")
    private Integer remainder;
    @Column(name="description")
    private String description;
    @Column(name="summary")
    private String summary;
    @Column(name="discount")
    private Integer discount;
    @Column(name="model")
    private String model;
    @Column(name="style1")
    private String style1;
    @Column(name="style4")
    private String style4;
    @Column(name="style3")
    private String style3;
    @Column(name="style2")
    private String style2;
}
