package com.ProductsApi.ProductsApi.Abstractions;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor()
@Getter()
public abstract class PageResponse<T> {
    private final List<T> elements;
    private final long totalItems;
}
