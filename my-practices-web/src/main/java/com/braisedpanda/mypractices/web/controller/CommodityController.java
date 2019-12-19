package com.braisedpanda.mypractices.web.controller;

import com.braisedpanda.mypractices.commons.model.Cart;
import com.braisedpanda.mypractices.commons.model.Commodity;
import com.braisedpanda.mypractices.commons.utils.DateUtils;
import com.braisedpanda.mypractices.web.config.security.SecurityUser;
import com.braisedpanda.mypractices.web.service.CommodityService;
import com.github.pagehelper.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: my-practices
 * @description: 商品Controller
 * @author: chenzhen
 * @create: 2019-12-18 16:34
 **/
@Api(tags = "商品类",description = "商品相关配置")
@RestController
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    /**
     * @Description: 登录验证后会执行这个方法
     * @Param: [model]
     * @Date: 2019/12/17 0017
     */
    @ApiOperation("展示商品")
    @RequestMapping("/index/{count}")
    public ModelAndView toindex(HttpSession session,@PathVariable("count") String count){
        ModelAndView modelAndView = new ModelAndView();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if("anonymousUser".equals(principal)) {
            session.setAttribute("name","anonymous");
        }else {
            SecurityUser user = (SecurityUser)principal;
            session.setAttribute("id",user.getId());
            session.setAttribute("name",user.getUsername());
        }
        //第一次进入首页
        if(count == null || StringUtil.isEmpty(count)){
            List<Commodity> commodityList =  commodityService.selectAllPage("1");
            modelAndView.addObject("list",commodityList);
            modelAndView.setViewName("index");
            return modelAndView;
        }
        List<Commodity> commodityList =  commodityService.selectAllPage(count);
        modelAndView.addObject("list",commodityList);
        modelAndView.setViewName("index");

        return modelAndView;
    }


    @ApiOperation("商品详情")
    @GetMapping("product_details/{id}")
    public ModelAndView commodityDetails(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        Commodity commodity = commodityService.selectCommodityById(id);
        modelAndView.addObject("commodity",commodity);
        modelAndView.setViewName("product-details");
        return modelAndView;
    }




}
