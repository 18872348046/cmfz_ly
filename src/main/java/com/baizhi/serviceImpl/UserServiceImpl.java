package com.baizhi.serviceImpl;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;
    @Override
    public void add(User user) {
        userDAO.insert(user);
    }

    @Override
    public void motify(User user) {
        userDAO.update(user);
    }

    @Override
    public String login(User user) {
        String users=userDAO.login(user);
        return users;

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void removeAll(String[] id) {

    }

    @Override

    public List<User> findAll() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User findById(String id) {
        return userDAO.queryById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAllPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return userDAO.queryAllPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findPage() {
        return userDAO.quertPage();
    }
}
