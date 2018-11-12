package com.baizhi.serviceImpl;

import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDAO menuDAO;
    @Override
    //查询菜单
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Menu> findAllMenu() {
        return menuDAO.queryAllMenu();
    }
}
