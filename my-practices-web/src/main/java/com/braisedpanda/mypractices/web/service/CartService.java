package com.braisedpanda.mypractices.web.service;

import com.braisedpanda.mypractices.commons.model.Cart;

import java.util.List;

public interface CartService {
    void insetCart(Cart cart);

    List<Cart> selectByUserId(int user_id);
}
