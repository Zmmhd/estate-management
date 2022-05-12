package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.domain.Building;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {

    List<T> findAll();

    Page<T> search(Map searchMap);

    Boolean add(T building);

    T findById(Integer id);

    Boolean update(T t);

    Boolean del(List<Integer> ids);
}
