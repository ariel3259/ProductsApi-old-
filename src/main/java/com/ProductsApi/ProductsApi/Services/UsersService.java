package com.ProductsApi.ProductsApi.Services;

import com.ProductsApi.ProductsApi.Abstractions.Mapper;
import com.ProductsApi.ProductsApi.Abstractions.Repository;
import com.ProductsApi.ProductsApi.Dto.*;
import com.ProductsApi.ProductsApi.Model.Roles;
import com.ProductsApi.ProductsApi.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService extends GenericServiceImp<Integer, Users, UsersRequest, UsersResponse, UsersUpdate>{

    private final Mapper<Integer, Roles, RolesRequest, RolesResponse, RolesUpdate> rolMapper;
    private final Repository<Integer, Roles> rolRepository;

    @Autowired()
    public UsersService(
            Repository<Integer, Users> repository,
            Repository<Integer, Roles> rolRepository,
            Mapper<Integer, Users, UsersRequest, UsersResponse, UsersUpdate> mapper,
            Mapper<Integer, Roles, RolesRequest, RolesResponse, RolesUpdate> rolMapper){
        super(repository, mapper);
        this.rolMapper = rolMapper;
        this.rolRepository = rolRepository;
    }

    public RolesResponse setRolOfUser(int rolId, int userId) {
        Users user = repository.findByIdAndStatus(userId, true);
        if (user == null) return new RolesResponse();
        Roles rol = rolRepository.findByIdAndStatus(rolId, true);
        if (rol == null) return new RolesResponse();
        user.setRol(rol);
        repository.save(user);
        return this.rolMapper.map(rol);
    }
}
