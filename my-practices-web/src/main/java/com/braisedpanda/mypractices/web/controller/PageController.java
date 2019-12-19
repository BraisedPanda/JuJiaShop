package com.braisedpanda.mypractices.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: my-practices
 * @description:
 * @author: chenzhen
 * @create: 2019-12-17 16:10
 **/
@RestController
@Api(tags = "页面跳转配置",description = "控制页面跳转")
public class PageController {

    @GetMapping("/home")
    @ApiOperation("点击后跳转到主页")
    public ModelAndView toHome(){
        return new ModelAndView("index");
    }

    @GetMapping("/shop")
    @ApiOperation("点击后跳转到商品主页")
    public ModelAndView toShop(){
        return new ModelAndView("shop");
    }

    @GetMapping("/productDetails")
    @ApiOperation("点击后跳转到商品详情")
    public ModelAndView toProductDetails(){
        return new ModelAndView("product-details");
    }




    @GetMapping("/checkout")
    @ApiOperation("点击后跳转到付款界面")
    public ModelAndView toCheckout(){
        return new ModelAndView("checkout");
    }

    @GetMapping("/person_info")
    @ApiOperation("点击后跳转到付款界面")
    public ModelAndView toPersonInfo(){
        return new ModelAndView("person-info");
    }

    @GetMapping("/main")
    @ApiOperation("点击后跳转到住页面")
    public ModelAndView toMain(){
        return new ModelAndView("main");
    }

    @GetMapping("/index2")
    @ApiOperation("点击后跳转到住页面")
    public ModelAndView toIndex2(){
        return new ModelAndView("index2");
    }
}
