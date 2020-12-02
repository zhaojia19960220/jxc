package com.atguigu.jxc.controller;

import com.atguigu.jxc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Zhao Jia
 * @date 2020/12/2 19:41
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // 请求URL：http://localhost:8080 /customer/list
    // 请求参数：Integer page, Integer rows, String  customerName
    // 客户列表分页（名称模糊查询）
    @PostMapping("/customer/list")
    public Map<String,Object>  getCustomersByName(Integer page,Integer rows,String customerName){
        Map<String,Object> map = customerService.getCustomers(page,rows,customerName);
        return map;
    }



}
