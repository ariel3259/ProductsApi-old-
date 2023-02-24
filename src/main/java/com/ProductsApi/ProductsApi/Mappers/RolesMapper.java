package com.ProductsApi.ProductsApi.Mappers;

import com.ProductsApi.ProductsApi.Abstractions.Mapper;
import com.ProductsApi.ProductsApi.Abstractions.PageResponse;
import com.ProductsApi.ProductsApi.Dto.RolesRequest;
import com.ProductsApi.ProductsApi.Dto.RolesResponse;
import com.ProductsApi.ProductsApi.Dto.RolesResponsePage;
import com.ProductsApi.ProductsApi.Dto.RolesUpdate;
import com.ProductsApi.ProductsApi.Model.Roles;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RolesMapper implements Mapper<Integer, Roles, RolesRequest, RolesResponse, RolesUpdate> {
    @Override
    public Roles map(RolesRequest request, String username) {
        return new Roles(request.getDescription(), username);
    }

    @Override
    public RolesResponse map(Roles entity) {
        return new RolesResponse(entity.getId(), entity.getDescription());
    }

    @Override
    public PageResponse<RolesResponse> map(PageResponse<Roles> entities) {
        List<RolesResponse> rolesResponse = new ArrayList<>();
        for(Roles rol: entities.getElements()) {
            rolesResponse.add(new RolesResponse(rol.getId(), rol.getDescription()));
        }
        return new RolesResponsePage(rolesResponse, entities.getTotalItems());
    }

    @Override
    public Roles map(RolesUpdate updateRequest, Roles entity, String username) {
        String description = updateRequest.getDescription().orElse(entity.getDescription());
        entity.setUpdateAt(new Date(System.currentTimeMillis()));
        entity.setUpdatedBy(username);
        entity.setDescription(description);
        return entity;
    }
}
