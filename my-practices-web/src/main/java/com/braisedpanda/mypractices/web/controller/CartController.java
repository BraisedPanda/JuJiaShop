package com.braisedpanda.mypractices.web.controller;

import com.braisedpanda.mypractices.commons.model.Cart;
import com.braisedpanda.mypractices.commons.model.CartDto;
import com.braisedpanda.mypractices.commons.model.Commodity;
import com.braisedpanda.mypractices.commons.utils.DateUtils;

import com.braisedpanda.mypractices.web.service.CartService;
import com.braisedpanda.mypractices.web.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: my-practices
 * @description:
 * @author: chenzhen
 * @create: 2019-12-19 11:52
 **/
@RestController
@Api(tags = "购物车类",description = "购物车类方法")
public class CartController {

    @Autowired
    private CommodityService commodityService;
    @Autowired
    private CartService cartService;


    @ApiOperation("添加至购物车")
    @PostMapping("addCart")
    public void addCart(String id, String count, HttpSession session){

        Cart cart = new Cart();
        int userId = (int)session.getAttribute("id");
        Commodity commodity = commodityService.selectCommodityById(id);
        Double price = commodity.getPrice();
        int count2 = Integer.parseInt(count);
        double total = price * count2;
        cart.setCommodityId(Integer.parseInt(id));
        cart.setCount(count2);
        cart.setTotal(total);
        cart.setUserId(userId);
        cart.setCreateTime(DateUtils.currentStandardDate());
        cartService.insetCart(cart);


    }

    @GetMapping("/cart")
    @ApiOperation("点击后跳转到我的购物车")
    public ModelAndView toCart(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        int user_id = (int)session.getAttribute("id");
        List<Cart> cartList = cartService.selectByUserId(user_id);
        List<CartDto> cartDtoList = new ArrayList<>();

        for (Cart cart:cartList) {
            CartDto cartDto = new CartDto();
            String commodity_id = cart.getCommodityId().toString();
            cartDto.setId(cart.getId());
            cartDto.setCommodity(commodityService.selectCommodityById(commodity_id));
            cartDto.setCount(cart.getCount());
            cartDto.setTotal(cart.getTotal());
            cartDtoList.add(cartDto);
        }
        modelAndView.addObject("cartList",cartDtoList);
        modelAndView.setViewName("cart");
        return modelAndView;
    }

}
