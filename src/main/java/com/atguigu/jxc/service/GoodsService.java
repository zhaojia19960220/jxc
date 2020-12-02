package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;

import java.util.Map;

public interface GoodsService {


    ServiceVO getCode();


    //分页查询商品库存信息
    Map<String, Object> listInventory(Integer page, Integer rows, String codeOrName, Integer goodsTypeId);
}
