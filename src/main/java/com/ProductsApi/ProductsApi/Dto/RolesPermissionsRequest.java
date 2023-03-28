package com.ProductsApi.ProductsApi.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.util.Set;

@Getter
public class RolesPermissionsRequest {

    @NotEmpty
    private Set<Integer> permissionsIds;
}
