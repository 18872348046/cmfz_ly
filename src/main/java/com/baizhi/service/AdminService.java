package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.util.IService;

public interface AdminService extends IService<Admin> {
    //登陆
    Admin findLogin(Admin admin);
    /*根据用户名查询*/
    Admin findUsername(String name);
}
