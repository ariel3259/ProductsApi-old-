package com.ProductsApi.ProductsApi.Mappers;

import com.ProductsApi.ProductsApi.Abstractions.Mapper;
import com.ProductsApi.ProductsApi.Abstractions.PageResponse;
import com.ProductsApi.ProductsApi.Dto.*;
import com.ProductsApi.ProductsApi.Model.Enterprises;
import com.ProductsApi.ProductsApi.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component()
public class UsersMapper implements Mapper<Integer, Users, UsersRequest, UsersResponse, UsersUpdate> {


    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Users map(UsersRequest request, String username) {
        String password = encoder.encode(request.getPassword());
        return new Users(request.getName(), request.getLastName(), request.getStreet(), request.getHeight(), request.getDni(), request.getEmail(), password, username);
    }

    @Override
    public UsersResponse map(Users entity) {
        RolesResponse rolResponse = new RolesResponse(entity.getRol().getId(), entity.getRol().getDescription());
        Set<EnterprisesResponse> enterprisesResponses = entity.getEnterprises()
                .stream()
                .map((enterprise) -> new EnterprisesResponse(enterprise.getId(), enterprise.getName(), enterprise.getDescription(), enterprise.getStreet(), enterprise.getHeight()))
                .collect(Collectors.toSet());
        Set<ProductsResponse> productsResponses = entity.getProducts()
                .stream()
                .map((products) -> {
                    Enterprises enterprise = products.getEnterprise();
                    EnterprisesResponse enterpriseResponse =  new EnterprisesResponse(enterprise.getId(), enterprise.getName(), enterprise.getDescription(), enterprise.getStreet(), enterprise.getHeight());
                    return new ProductsResponse(products.getId(), products.getName(), products.getPrice(), products.getStock(), enterpriseResponse);
                })
                .collect(Collectors.toSet());
        return new UsersResponse(entity.getId(), entity.getName(), entity.getLastname(), entity.getStreet(), entity.getHeight(), entity.getDni(), rolResponse, enterprisesResponses, productsResponses);
    }

    @Override
    public PageResponse<UsersResponse> map(Page<Users> entities) {
        List<UsersResponse> usersResponses = entities.getContent()
                .stream()
                .map(this::map)
                .toList();
        PageResponse<UsersResponse> response = new UsersResponsePage(usersResponses, entities.getTotalElements());
        return response;
    }

    @Override
    public Users map(UsersUpdate updateRequest, Users entity, String username) {
        String name = updateRequest.getName().orElse(entity.getName());
        String lastname = updateRequest.getLastName().orElse(entity.getLastname());
        String street = updateRequest.getStreet().orElse(entity.getStreet());
        int height = updateRequest.getHeight().orElse(entity.getHeight());
        long dni = updateRequest.getDni().orElse(entity.getDni());
        String password = "";
        if (updateRequest.getPassword().isPresent()) {
            password = encoder.encode(updateRequest.getPassword().get());
        }
        else password = entity.getPassword();
        entity.setName(name);
        entity.setLastname(lastname);
        entity.setStreet(street);
        entity.setHeight(height);
        entity.setDni(dni);
        entity.setPassword(password);
        return entity;
    }
}
