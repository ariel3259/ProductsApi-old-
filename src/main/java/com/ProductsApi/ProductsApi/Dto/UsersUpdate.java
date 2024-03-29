package com.ProductsApi.ProductsApi.Dto;

import lombok.Getter;

import java.util.Optional;

@Getter()
public class UsersUpdate {
    private Optional<String> name;
    private Optional<String> lastName;
    private Optional<String> street;
    private Optional<Integer> height;
    private Optional<Long> dni;
    private Optional<Integer> rolId;
    private Optional<String> password;
}
