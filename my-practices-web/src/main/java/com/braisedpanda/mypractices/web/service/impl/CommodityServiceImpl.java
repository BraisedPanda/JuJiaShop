package com.braisedpanda.mypractices.web.service.impl;

import com.braisedpanda.mypractices.commons.model.Commodity;
import com.braisedpanda.mypractices.web.mapper.CommodityMapper;
import com.braisedpanda.mypractices.web.service.CommodityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: my-practices
 * @description:
 * @author: chenzhen
 * @create: 2019-12-18 16:35
 **/
@Service
@Component
public class CommodityServiceImpl implements CommodityService{
    @Autowired
    private CommodityMapper commodityMapper;

    //分页查找所有商品
    @Override
    public List<Commodity> selectAllPage(String count) {
        PageHelper.startPage(Integer.parseInt(count),9);
        List<Commodity> commodityList = commodityMapper.selectAll();
        PageInfo info = new PageInfo(commodityList);
        List<Commodity> resultList = info.getList();
        return resultList;
    }


    //根据商品id查找商品
    @Override
    public Commodity selectCommodityById(String id) {
        Commodity commodity = commodityMapper.selectByPrimaryKey(id);
        return commodity;
    }


}
