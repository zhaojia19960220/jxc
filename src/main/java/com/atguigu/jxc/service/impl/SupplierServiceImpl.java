package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.SupplierDao;
import com.atguigu.jxc.domain.ErrorCode;
import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.domain.SuccessCode;
import com.atguigu.jxc.entity.Goods;
import com.atguigu.jxc.entity.Log;
import com.atguigu.jxc.entity.Supplier;
import com.atguigu.jxc.service.LogService;
import com.atguigu.jxc.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhao Jia
 * @date 2020/12/2 15:35
 */
//供应商管理
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;

    @Autowired
    private LogService logService;

    //分页查询供应商
    @Override
    public Map<String, Object> findAllSuppliers(Integer page, Integer rows, String supplierName) {
        Map<String,Object> map = new HashMap<>();

        page = page == 0 ? 1 : page;
        int offSet = (page - 1) * rows;

        List<Supplier> supplierList = supplierDao.getSuppliersByPage(offSet, rows,supplierName);

        map.put("rows", supplierList);
        return map;
    }

    //供应商添加或修改
    @Override
    public ServiceVO saveSupplier(Supplier supplier) {
        if(supplier.getSupplierId()==null){
            //Supplier exSupplier = supplierDao.findSupplierByName(supplier.getSupplierName());
            /*if(exSupplier!=null){
                return new ServiceVO<>(ErrorCode.ROLE_EXIST_CODE,ErrorCode.ROLE_EXIST_MESS);
            }*/
            logService.save(new Log(Log.INSERT_ACTION,"新增供应商："+supplier.getSupplierName()));
            supplierDao.insertSuppiler(supplier);
        }else{
            logService.save(new Log(Log.UPDATE_ACTION,"修改供应商："+supplier.getSupplierName()));
            supplierDao.updateSupplier(supplier);
        }
        return new ServiceVO(SuccessCode.SUCCESS_CODE,SuccessCode.SUCCESS_MESS);
    }

    // 删除供应商
    @Override
    public void deleteSuppliers(List<String> idList) {
        supplierDao.deleteSuppliers(idList);
    }
}
