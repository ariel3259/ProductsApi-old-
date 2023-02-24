package com.ProductsApi.ProductsApi.Services;

import com.ProductsApi.ProductsApi.Abstractions.Mapper;
import com.ProductsApi.ProductsApi.Abstractions.Repository;
import com.ProductsApi.ProductsApi.Dto.RolesRequest;
import com.ProductsApi.ProductsApi.Dto.RolesResponse;
import com.ProductsApi.ProductsApi.Dto.RolesUpdate;
import com.ProductsApi.ProductsApi.Model.Roles;
import org.springframework.beans.factory.annotation.Autowired;

public class RolesService extends GenericServiceImp<Integer, Roles, RolesRequest, RolesResponse, RolesUpdate>{

    @Autowired
    public RolesService(Mapper<Integer, Roles, RolesRequest, RolesResponse, RolesUpdate> mapper, Repository<Integer, Roles> repository){
        super(repository, mapper);
    }
}
