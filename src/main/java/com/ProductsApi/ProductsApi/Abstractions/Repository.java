package com.ProductsApi.ProductsApi.Abstractions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface Repository<ID extends Serializable, T> extends JpaRepository<T, ID> {

    Page<T> findAllByStatus(Pageable page, boolean status);

    T getReferenceByIdAndStatus(ID id, boolean status);

}
