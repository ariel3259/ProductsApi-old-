package com.ProductsApi.ProductsApi.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EnterprisesResponse {
    private int enterprisesId;
    private String name;
    private String description;
    private String street;
    private int height;

}
