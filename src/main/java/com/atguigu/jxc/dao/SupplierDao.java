package com.atguigu.jxc.dao;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.Supplier;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zhao Jia
 * @date 2020/12/2 15:46
 */
//供应商管理

public interface SupplierDao {

    //分页查询供应商
    List<Supplier> getSuppliersByPage(@Param("offSet")int offSet, @Param("rows")Integer rows,@Param("supplierName") String supplierName);


    //供应商添加或修改
    void insertSuppiler(Supplier supplier);

    //供应商修改
    void updateSupplier(Supplier supplier);

    // 删除供应商
    void deleteSuppliers(List<String> idList);


}
