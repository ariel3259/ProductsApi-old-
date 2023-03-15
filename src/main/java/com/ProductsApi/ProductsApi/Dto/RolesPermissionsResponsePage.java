package com.ProductsApi.ProductsApi.Dto;

import com.ProductsApi.ProductsApi.Abstractions.PageResponse;

import java.util.List;

public class RolesPermissionsResponsePage extends PageResponse<RolesPermissionsResponse> {

    public RolesPermissionsResponsePage(List<RolesPermissionsResponse> rolesPermissionsResponses, long totalCount){
        super(rolesPermissionsResponses, totalCount);
    }
}
