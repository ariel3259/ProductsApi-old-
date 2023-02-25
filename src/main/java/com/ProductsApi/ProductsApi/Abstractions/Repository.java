package com.ProductsApi.ProductsApi.Abstractions;

import org.springframework.data.domain.Page;

import java.util.Optional;


public interface Repository<ID,T extends BaseEntity<ID>> {

    PageResponse<T> getAll(Optional<Integer> offset, Optional<Integer> limit);
    T getById(ID id);
    T save(T entity);
    T update(T entity);
    void delete(ID id);
}
