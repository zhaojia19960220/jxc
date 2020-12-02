package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Zhao Jia
 * @date 2020/12/2 15:24
 */
//供应商管理
@RestController
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    //请求URL：http://localhost:8080/supplier/list
    // 请求参数：Integer page（当前页数）, Integer rows（每页显示的记录数）, String supplierName
    //分页查询供应商
    @RequestMapping("/supplier/list")
    @ResponseBody
    public Map<String,Object> findAllSuppliers(Integer page,Integer rows,String supplierName){
        Map<String,Object> map = supplierService.findAllSuppliers(page,rows,supplierName);
        return map;
    }

    //请求URL：http://localhost:8080/supplier/save?supplierId=1
    //请求参数：Supplier supplier
    //供应商添加或修改
    @RequestMapping("/supplier/save")
    public ServiceVO save(Supplier supplier ){
        ServiceVO serviceVO = supplierService.saveSupplier(supplier);
        return serviceVO;

    }

    //删除供应商
    //http://localhost:8080/supplier/delete
    @PostMapping("/supplier/delete")
    public ServiceVO delete(String[] ids){
        List<String> idList = (List<String>) Arrays.asList(ids);
        supplierService.deleteSuppliers(idList);
        ServiceVO serviceVO = new ServiceVO(100,"请求成功",null);
        return serviceVO;
    }


}
