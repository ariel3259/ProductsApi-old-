package com.ProductsApi.ProductsApi.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductsResponse {
    private int productsId;
    private String name;
    private double price;
    private int stock;
    private EnterprisesResponse enterprise;

}
