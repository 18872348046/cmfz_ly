package com.baizhi.serviceImpl;

import com.baizhi.dao.AlbumDAO;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Resource
    private AlbumDAO albumDAO;
    @Override
    public void add(Album album) {
        album.setId(UUID.randomUUID().toString().replace("-",""));
        albumDAO.insert(album);
    }

    @Override
    public void motify(Album album) {
        albumDAO.update(album);
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void removeAll(String[] id) {

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findAll() {
        return albumDAO.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Album findById(String id) {
        return albumDAO.queryById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Album> findAllPage(Integer page, Integer rows) {
        int start=(page-1)*rows;
        return albumDAO.queryAllPage(start,rows);
    }

    @Override
    public Long findPage() {
        return albumDAO.quertPage();
    }
}
