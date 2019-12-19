package com.braisedpanda.mypractices.web.service;

import com.braisedpanda.mypractices.commons.model.Commodity;

import java.util.List;

public interface CommodityService {
    List<Commodity> selectAllPage(String count);

    Commodity selectCommodityById(String id);
}
