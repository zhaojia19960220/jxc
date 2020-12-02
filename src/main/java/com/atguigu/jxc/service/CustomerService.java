package com.atguigu.jxc.service;

import java.util.Map;

/**
 * @author Zhao Jia
 * @date 2020/12/2 21:00
 */
public interface CustomerService {

    // 客户列表分页（名称模糊查询）
    Map<String, Object> getCustomers(Integer page, Integer rows, String customerName);
}
