package com.baizhi.service;

import com.baizhi.entity.Article;
import com.baizhi.util.IService;

import java.util.List;

public interface ArticleService extends IService<Article> {
    List<Article> findAllPageArticle(Integer page,Integer rows,String classift);
    Long findPageArticle(String classift);
}
