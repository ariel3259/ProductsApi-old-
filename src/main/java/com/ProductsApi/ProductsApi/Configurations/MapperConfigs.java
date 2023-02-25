package com.ProductsApi.ProductsApi.Configurations;

import com.ProductsApi.ProductsApi.Abstractions.Mapper;
import com.ProductsApi.ProductsApi.Dto.RolesRequest;
import com.ProductsApi.ProductsApi.Dto.RolesResponse;
import com.ProductsApi.ProductsApi.Dto.RolesUpdate;
import com.ProductsApi.ProductsApi.Mappers.RolesMapper;
import com.ProductsApi.ProductsApi.Model.Roles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class MapperConfigs {

    @Bean()
    public Mapper<Integer, Roles, RolesRequest, RolesResponse, RolesUpdate> rolMap(){
        return new RolesMapper();
    }
}
