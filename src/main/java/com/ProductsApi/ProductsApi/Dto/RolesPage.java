package com.ProductsApi.ProductsApi.Dto;

import com.ProductsApi.ProductsApi.Abstractions.PageResponse;
import com.ProductsApi.ProductsApi.Model.Roles;
import lombok.AllArgsConstructor;

import java.util.List;

public class RolesPage extends PageResponse<Roles> {
    public RolesPage(List<Roles> r, long ti){
        super(r, ti);
    }
}
