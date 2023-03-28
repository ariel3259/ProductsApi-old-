package com.ProductsApi.ProductsApi.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsersRequest {
    private String name;
    private String lastName;
    private String street;
    private int height;
    private long dni;
    private String email;
    private String password;
    private int rolId;
}
