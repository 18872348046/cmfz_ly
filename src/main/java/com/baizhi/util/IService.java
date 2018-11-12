package com.baizhi.util;

import java.util.List;

public interface IService<T>{
    void add(T t);
    void motify(T t);
    void remove(String id);
    void removeAll(String[] id);
    List<T> findAll();
    T findById(String id);
    List<T> findAllPage(Integer page, Integer rows);
    Long findPage();
}
