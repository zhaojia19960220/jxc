package com.atguigu.jxc.service;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Supplier;

import java.util.List;
import java.util.Map;

/**
 * @author Zhao Jia
 * @date 2020/12/2 15:39
 */
public interface SupplierService {

    //分页查询供应商
    Map<String, Object> findAllSuppliers(Integer page, Integer rows, String supplierName);

    //供应商添加或修改
    ServiceVO saveSupplier(Supplier supplier);

    // 删除供应商
    void deleteSuppliers(List<String> idList);

}
