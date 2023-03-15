package com.ProductsApi.ProductsApi.Dto;

import lombok.Getter;

import java.util.Set;

@Getter
public class RolesPermissionsRequest {
    private Set<Integer> permissionsIds;
}
