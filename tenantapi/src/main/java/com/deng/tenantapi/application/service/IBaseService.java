package com.deng.tenantapi.application.service;

import java.util.List;
import java.util.Optional;

public interface IBaseService<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
}
