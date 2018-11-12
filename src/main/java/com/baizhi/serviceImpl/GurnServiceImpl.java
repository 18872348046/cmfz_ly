package com.baizhi.serviceImpl;

import com.baizhi.dao.GurnDAO;
import com.baizhi.entity.Gurn;
import com.baizhi.service.GurnService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GurnServiceImpl implements GurnService {
    @Resource
    private GurnDAO gurnDAO;
    @Override
    public void add(Gurn gurn) {
        gurn.setId(UUID.randomUUID().toString().replace("-",""));
        gurnDAO.insert(gurn);
    }

    @Override
    public void motify(Gurn gurn) {
        gurnDAO.update(gurn);
    }

    @Override
    public void remove(String id) {
        gurnDAO.delete(id);
    }

    @Override
    public void removeAll(String[] id) {
        gurnDAO.deleteAll(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Gurn> findAll() {
        return gurnDAO.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Gurn findById(String id) {
        return gurnDAO.queryById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Gurn> findAllPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return gurnDAO.queryAllPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findPage() {
        return gurnDAO.quertPage();
    }
}
