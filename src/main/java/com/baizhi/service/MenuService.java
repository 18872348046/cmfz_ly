package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

public interface MenuService {
    //查询菜单
    List<Menu> findAllMenu();
}
