package com.ProductsApi.ProductsApi.Dto;

import com.ProductsApi.ProductsApi.Abstractions.PageResponse;

import java.util.List;

public class RolesResponsePage extends PageResponse<RolesResponse> {

    public RolesResponsePage(List<RolesResponse> re, long ti){
        super(re, ti);
    }
}
