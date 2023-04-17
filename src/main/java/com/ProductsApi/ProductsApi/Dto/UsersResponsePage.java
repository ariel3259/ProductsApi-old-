package com.ProductsApi.ProductsApi.Dto;

import com.ProductsApi.ProductsApi.Abstractions.PageResponse;

import java.util.List;

public class UsersResponsePage extends PageResponse<UsersResponse> {

    public UsersResponsePage(List<UsersResponse> users, long totalItems){
        super(users, totalItems);
    }
}
