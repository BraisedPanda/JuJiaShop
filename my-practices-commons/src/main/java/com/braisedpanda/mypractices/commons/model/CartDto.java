package com.braisedpanda.mypractices.commons.model;

import lombok.Data;

/**
 * @program: my-practices
 * @description:
 * @author: chenzhen
 * @create: 2019-12-19 11:28
 **/
@Data
public class CartDto extends Cart{
    private Commodity commodity;
}
