package com.ProductsApi.ProductsApi.Services;

import com.ProductsApi.ProductsApi.Abstractions.Mapper;
import com.ProductsApi.ProductsApi.Abstractions.Repository;
import com.ProductsApi.ProductsApi.Dto.RolesPermissionsRequest;
import com.ProductsApi.ProductsApi.Dto.RolesPermissionsResponse;
import com.ProductsApi.ProductsApi.Model.Permissions;
import com.ProductsApi.ProductsApi.Model.Roles;
import org.springframework.beans.factory.annotation.Autowired;

public class RolesPermissionsService extends GenericServiceImp<Integer, Roles, RolesPermissionsRequest, RolesPermissionsResponse, RolesPermissionsRequest>{

    private final Repository<Integer, Permissions> permissionsRepository;
    @Autowired
    public RolesPermissionsService(
            Mapper<Integer, Roles, RolesPermissionsRequest, RolesPermissionsResponse, RolesPermissionsRequest> mapper,
            Repository<Integer, Roles> rolesRepository,
            Repository<Integer, Permissions> permissionsRepository
    ){
        super(rolesRepository, mapper);
        this.permissionsRepository = permissionsRepository;
    }
}
