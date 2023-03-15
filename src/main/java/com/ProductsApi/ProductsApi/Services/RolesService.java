package com.ProductsApi.ProductsApi.Services;

import com.ProductsApi.ProductsApi.Abstractions.GenericService;
import com.ProductsApi.ProductsApi.Abstractions.Mapper;
import com.ProductsApi.ProductsApi.Abstractions.Repository;
import com.ProductsApi.ProductsApi.Dto.*;
import com.ProductsApi.ProductsApi.Model.Permissions;
import com.ProductsApi.ProductsApi.Model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class RolesService extends GenericServiceImp<Integer, Roles, RolesRequest, RolesResponse, RolesUpdate>  {

    @Autowired
    public RolesService(Mapper<Integer, Roles, RolesRequest, RolesResponse, RolesUpdate> mapper, Repository<Integer, Roles> repository){
        super(repository, mapper);
    }

    public List<RolesPermissionsResponse> getAllRolesPermissions(){
        List<Roles> roles = repository.findAllByStatus(true);
        List<RolesPermissionsResponse> response = roles
                .stream()
                .map((rol) -> {
                    Set<Permissions> permissions = rol.getPermissions();
                    Set<PermissionsResponse> permissionsResponses = permissions
                            .stream()
                            .map((permission) -> new PermissionsResponse(permission.getId(), permission.getDescription()))
                            .collect(Collectors.toSet());
                    return new RolesPermissionsResponse(rol.getId(), permissionsResponses);
                })
                .toList();
        return response;
    }
}
