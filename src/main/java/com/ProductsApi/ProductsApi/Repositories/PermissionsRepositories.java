package com.ProductsApi.ProductsApi.Repositories;

import com.ProductsApi.ProductsApi.Abstractions.Repository;
import com.ProductsApi.ProductsApi.Model.Permissions;

@org.springframework.stereotype.Repository
public interface PermissionsRepositories extends Repository<Integer, Permissions> {
}
