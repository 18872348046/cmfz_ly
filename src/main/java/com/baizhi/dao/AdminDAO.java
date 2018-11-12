package com.baizhi.dao;

import com.baizhi.entity.Admin;
import com.baizhi.util.IDao;

public interface AdminDAO extends IDao<Admin> {
    //登陆
    Admin queryLogin(Admin admin);
    /*根据用户名查询*/
    Admin queryUsername(String name);
}
