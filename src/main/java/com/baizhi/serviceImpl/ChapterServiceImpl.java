package com.baizhi.serviceImpl;

import com.baizhi.dao.ChapterDAO;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Resource
    private ChapterDAO chapterDAO;
    @Override
    public void add(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString().replace("-",""));
        chapterDAO.insert(chapter);
    }

    @Override
    public void motify(Chapter chapter) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void removeAll(String[] id) {

    }

    @Override
    public List<Chapter> findAll() {
        return null;
    }

    @Override
    public Chapter findById(String id) {
        return null;
    }

    @Override
    public List<Chapter> findAllPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public Long findPage() {
        return null;
    }
}
