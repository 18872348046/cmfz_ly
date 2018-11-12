package com.baizhi.util;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDao<T>{
    void insert(T t);
    void update(T t);
    void delete(String id);
    void deleteAll(String[] id);
    List<T> queryAll();
    T queryById(String id);
    List<T> queryAllPage(@Param("start") Integer start, @Param("rows") Integer rows);
    Long quertPage();

}
