package com.baizhi.dao;

import com.baizhi.entity.Article;
import com.baizhi.util.IDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDAO extends IDao<Article> {
    List<Article> queryAllPageArticle(@Param("start") Integer start, @Param("rows") Integer rows,@Param("classift") String classift);
    Long quertPageArticle(@Param("classift") String classift);
}
