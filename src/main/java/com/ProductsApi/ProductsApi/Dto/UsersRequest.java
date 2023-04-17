package com.ProductsApi.ProductsApi.Dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsersRequest {
    @NotEmpty()
    private String name;
    @NotEmpty()
    private String lastName;
    @NotEmpty()
    private String street;
    @NotNull()
    private int height;
    @NotNull()
    private long dni;
    @NotNull()
    private String email;
    @NotNull()
    private String password;
    @NotNull()
    private int rolId;
}
