package com.jbobadilla.generic;

import java.util.List;

public interface Repository<T> {
    void save(T entity);
    T findById(String code);
    List<T> findAll();
    void delete(String code);
}
