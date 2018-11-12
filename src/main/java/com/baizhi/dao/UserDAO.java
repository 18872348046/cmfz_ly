package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baizhi.util.IDao;

public interface UserDAO extends IDao<User> {
    /*登陆*/
    String login(User user);
}
