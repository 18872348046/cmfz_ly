package com.baizhi.serviceImpl;

import com.baizhi.dao.ArticleDAO;
import com.baizhi.entity.Article;
import com.baizhi.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDAO articleDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> findAllPageArticle(Integer page, Integer rows, String classift) {
        int start=(page-1)*rows;
        return articleDAO.queryAllPageArticle(start,rows,classift);
    }

    @Override
    public void add(Article article) {
        article.setId(UUID.randomUUID().toString().replace("-",""));
        articleDAO.insert(article);
    }

    @Override
    public void motify(Article article) {
        articleDAO.update(article);
    }

    @Override
    public void remove(String id) {
        articleDAO.delete(id);
    }

    @Override
    public void removeAll(String[] id) {
        articleDAO.deleteAll(id);
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Article findById(String id) {
        return articleDAO.queryById(id);
    }

    @Override
    public List<Article> findAllPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findPageArticle(String classift) {
        return articleDAO.quertPageArticle(classift);
    }

    @Override
    public Long findPage() {
        return  null;
    }
}
