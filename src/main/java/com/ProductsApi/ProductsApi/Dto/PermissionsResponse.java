package com.ProductsApi.ProductsApi.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor()
@Getter
public class PermissionsResponse {
    private int permissionsId;
    private String description;
}
