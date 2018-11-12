package com.baizhi.serviceImpl;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Override
    public List<Admin> findAllPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public void removeAll(String[] id) {

    }

    @Override
    public Long findPage() {
        return null;
    }

    @Autowired
    private AdminDAO adminDAO;
    @Override
    //管理员登陆
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findLogin(Admin admin) {
       Admin admins=adminDAO.queryLogin(admin);
        return admins;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findUsername(String name) {
        return adminDAO.queryUsername(name);
    }

    //增加管理员
    @Override
    public void add(Admin admin) {
        adminDAO.insert(admin);
    }

    //修改管理员
    @Override
    public void motify(Admin admin) {
        adminDAO.update(admin);
    }

    //删除管理员
    @Override
    public void remove(String id) {
        adminDAO.delete(id);
    }

    //查询全部管理员
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Admin> findAll() {
        return adminDAO.queryAll();
    }

    //根据id查询管理员
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findById(String id) {
        return adminDAO.queryById(id);
    }
}
