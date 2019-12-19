package com.braisedpanda.mypractices.web.service.impl;

import com.braisedpanda.mypractices.commons.model.Cart;
import com.braisedpanda.mypractices.web.mapper.CartMapper;
import com.braisedpanda.mypractices.web.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: my-practices
 * @description:
 * @author: chenzhen
 * @create: 2019-12-19 11:52
 **/
@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void insetCart(Cart cart) {
        cartMapper.insert(cart);
    }
    //根据userid查找该用户的购物车

    @Override
    public List<Cart> selectByUserId(int user_id) {
        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",user_id);
        List<Cart> cartList = cartMapper.selectByExample(example);
        return cartList;
    }
}
