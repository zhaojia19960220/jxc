package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Customer;

import java.util.List;

/**
 * @author Zhao Jia
 * @date 2020/12/2 21:08
 */
public interface CustomerDao {
    // 客户列表分页（名称模糊查询）
    List<Customer> getCustomers(int offSet, Integer rows, String customerName);
}
