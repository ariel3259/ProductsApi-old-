package com.ProductsApi.ProductsApi.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter()
public class RolesRequest {
    @NotBlank()
    private String description;
}
