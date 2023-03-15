package com.ProductsApi.ProductsApi.Mappers;

import com.ProductsApi.ProductsApi.Abstractions.Mapper;
import com.ProductsApi.ProductsApi.Abstractions.PageResponse;
import com.ProductsApi.ProductsApi.Dto.PermissionsResponse;
import com.ProductsApi.ProductsApi.Dto.RolesPermissionsRequest;
import com.ProductsApi.ProductsApi.Dto.RolesPermissionsResponse;
import com.ProductsApi.ProductsApi.Model.Permissions;
import com.ProductsApi.ProductsApi.Model.Roles;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RolesPermissionsMapper implements Mapper<Integer, Roles, RolesPermissionsRequest, RolesPermissionsResponse, RolesPermissionsRequest> {
    @Override
    public Roles map(RolesPermissionsRequest request, String username) {
        return null;
    }

    @Override
    public RolesPermissionsResponse map(Roles entity) {
        Set<Permissions> permissions = entity.getPermissions();
        Set<PermissionsResponse> permissionsResponse = permissions
                .stream()
                .map(x -> new PermissionsResponse(x.getPermissionsId(), x.getDescription()))
                .collect(Collectors.toSet());
        return new RolesPermissionsResponse(entity.getRolesId(), permissionsResponse);
    }

    @Override
    public PageResponse<RolesPermissionsResponse> map(Page<Roles> entities) {
        return null;
    }

    @Override
    public Roles map(RolesPermissionsRequest updateRequest, Roles entity, String username) {
        return null;
    }
}
