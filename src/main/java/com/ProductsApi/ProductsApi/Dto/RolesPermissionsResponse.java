package com.ProductsApi.ProductsApi.Dto;

import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class RolesPermissionsResponse {
    private int rolesId;
    private Set<PermissionsResponse> permissions;
}
