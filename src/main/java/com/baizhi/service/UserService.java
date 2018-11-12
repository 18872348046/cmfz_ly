package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.entity.User;
import com.baizhi.util.IService;

public interface UserService extends IService<User> {
    /*用户登陆*/
    String login(User user);

}
