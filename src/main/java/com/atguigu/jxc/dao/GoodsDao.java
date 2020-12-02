package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description 商品信息
 */

public interface GoodsDao {

    String getMaxCode();

    //分页查询商品库存信息
    List<Goods> getGoodsInventoryList(@Param("offSet")Integer offSet,@Param("pageRow") Integer pageRow, @Param("codeOrName") String codeOrName,@Param("goodsTypeId") Integer goodsTypeId);

    List<Goods> getGoodsInventoryCount(@Param("codeOrName") String codeOrName,@Param("goodsTypeId") Integer goodsTypeId);

}
