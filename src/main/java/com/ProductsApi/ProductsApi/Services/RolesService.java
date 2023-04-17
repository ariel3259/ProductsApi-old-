package com.ProductsApi.ProductsApi.Services;

import com.ProductsApi.ProductsApi.Abstractions.Mapper;
import com.ProductsApi.ProductsApi.Abstractions.PageResponse;
import com.ProductsApi.ProductsApi.Abstractions.Repository;
import com.ProductsApi.ProductsApi.Dto.*;
import com.ProductsApi.ProductsApi.Model.Permissions;
import com.ProductsApi.ProductsApi.Model.Roles;
import com.ProductsApi.ProductsApi.Repositories.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;


@Service
public class RolesService extends GenericServiceImp<Integer, Roles, RolesRequest, RolesResponse, RolesUpdate>  {

    private final Repository<Integer, Permissions> permissionsRepository;

    @Autowired
    public RolesService(
            Mapper<Integer, Roles, RolesRequest, RolesResponse, RolesUpdate> mapper,
            Repository<Integer, Roles> repository,
            Repository<Integer, Permissions> permissionsRepository
    ){
        super(repository, mapper);
        this.permissionsRepository = permissionsRepository;
    }

    public PageResponse<RolesPermissionsResponse> getAllRolesPermissions(Optional<Integer> page, Optional<Integer> limit){
        Pageable pageRequest = PageRequest.of(page.orElse(0), limit.orElse(10));
        Page<Roles> roles = repository.findAllByStatus(pageRequest,true);
        List<RolesPermissionsResponse> rolesPermissionResponse = roles
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
        RolesPermissionsResponsePage response = new RolesPermissionsResponsePage(rolesPermissionResponse, roles.getNumberOfElements());
        return response;
    }

    public RolesPermissionsResponse getOneRolPermissions(int rolId) {
        Roles rol = repository.getReferenceByIdAndStatus(rolId, true);
        if(rol == null) return new RolesPermissionsResponse();
        Set<Permissions> permissions = rol.getPermissions();
        Set<PermissionsResponse> permissionsResponse = permissions
                .stream()
                .map((permission) -> new PermissionsResponse(permission.getId(), permission.getDescription()))
                .collect(Collectors.toSet());
        return new RolesPermissionsResponse(rolId, permissionsResponse);
    }

    public RolesPermissionsResponse update(RolesPermissionsRequest request, int rolId){
        Set<Integer> permissionsIds = request.getPermissionsIds();
        List<Permissions> allPermissions = permissionsRepository.findAllById(permissionsIds);
        Set<Permissions> permissions = allPermissions
                .stream()
                .filter(Permissions::getStatus)
                .collect(Collectors.toSet());
        Roles rol = repository.getReferenceByIdAndStatus(rolId, true);
        if(rol == null || permissions.isEmpty()) return new RolesPermissionsResponse();
        rol.setPermissions(permissions);
        repository.save(rol);
        Set<PermissionsResponse> permissionsResponse = permissions
                .stream()
                .map((permission) -> new PermissionsResponse(permission.getId(), permission.getDescription()))
                .collect(Collectors.toSet());
        RolesPermissionsResponse response = new RolesPermissionsResponse(rolId, permissionsResponse);
        return response;
    }
}
