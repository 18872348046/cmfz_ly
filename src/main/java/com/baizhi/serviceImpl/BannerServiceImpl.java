package com.baizhi.serviceImpl;

import com.baizhi.dao.BannerDAO;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerDAO bannerDAO;
    @Override
    public void add(Banner banner) {
        banner.setId(UUID.randomUUID().toString().replace("-",""));
        bannerDAO.insert(banner);
    }

    @Override
    public void motify(Banner banner) {
        bannerDAO.update(banner);
    }
    /*根据id删除轮播图片*/
    @Override
    public void remove(String id) {
        bannerDAO.delete(id);
    }

    @Override
    public List<Banner> findAll() {
        return null;
    }

    @Override
    //批量删除
    public void removeAll(String[] id) {
        bannerDAO.deleteAll(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Banner findById(String id) {
        return bannerDAO.queryById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Banner> findAllPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return bannerDAO.queryAllPage(start,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findPage() {
        return bannerDAO.quertPage();
    }
}
