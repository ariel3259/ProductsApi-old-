package com.ProductsApi.ProductsApi.Dto;

import com.ProductsApi.ProductsApi.Abstractions.PageResponse;

import java.util.List;

public class PermissionsResponsePage extends PageResponse<PermissionsResponse> {
    public PermissionsResponsePage(List<PermissionsResponse> elements, long totalItems){
        super(elements, totalItems);
    }
}
