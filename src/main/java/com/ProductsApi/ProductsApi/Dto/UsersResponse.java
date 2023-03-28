package com.ProductsApi.ProductsApi.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class UsersResponse {

    private int usersId;
    private String name;
    private String lastName;
    private String street;
    private int height;
    private long dni;
    private RolesResponse rol;
    private Set<EnterprisesResponse> enterprises;
    private Set<ProductsResponse> products;

}
