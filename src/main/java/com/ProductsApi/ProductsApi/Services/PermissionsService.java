package com.ProductsApi.ProductsApi.Services;

import com.ProductsApi.ProductsApi.Model.Permissions;
import com.ProductsApi.ProductsApi.Repositories.PermissionsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionsService {

    @Autowired
    private PermissionsRepositories repository;

    public Page<Permissions> getAll(Optional<Integer> page, Optional<Integer> limit) {
        Pageable pageRequest = PageRequest.of(page.orElse(0), limit.orElse(10));
        Page<Permissions> permissionsPage = repository.findAllByStatus(pageRequest, true);
        return permissionsPage;
    }
}
