package com.ProductsApi.ProductsApi.Repositories;

import com.ProductsApi.ProductsApi.Abstractions.Repository;
import com.ProductsApi.ProductsApi.Model.Users;

@org.springframework.stereotype.Repository
public interface UsersRepository extends Repository<Integer, Users> {
     Users findOneByEmailAndStatus(String email, boolean status);
}
