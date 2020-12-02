package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerDao;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhao Jia
 * @date 2020/12/2 21:00
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    // 客户列表分页（名称模糊查询）
    @Override
    public Map<String, Object> getCustomers(Integer page, Integer rows, String customerName) {
        Map<String,Object> map = new HashMap<>();

        page = page == 0 ? 1 : page;
        int offSet = (page - 1) * rows;

        List<Customer> customerList = customerDao.getCustomers(offSet, rows,customerName);

        map.put("rows", customerList);
        return map;
    }
}
