package com.ProductsApi.ProductsApi.Dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class RolesPermissionsResponse {
    private int rolesId;
    private Set<PermissionsResponse> permissions;
}
