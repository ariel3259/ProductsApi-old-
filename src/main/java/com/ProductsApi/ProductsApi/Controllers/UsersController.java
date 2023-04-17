package com.ProductsApi.ProductsApi.Controllers;

import com.ProductsApi.ProductsApi.Abstractions.GenericService;
import com.ProductsApi.ProductsApi.Abstractions.PageResponse;
import com.ProductsApi.ProductsApi.Dto.*;
import com.ProductsApi.ProductsApi.Model.Users;
import com.ProductsApi.ProductsApi.Services.UsersService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    GenericService<Integer, Users, UsersRequest, UsersResponse, UsersUpdate> service;

    @GetMapping()
    public List<UsersResponse> getAll(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("limit") Optional<Integer> limit,
            HttpServletResponse res
            ){
        PageResponse<UsersResponse> usersResponse = service.getAll(page, limit);
        String xTotalCount = String.valueOf(usersResponse.getTotalItems());
        res.setHeader("x-total-count", xTotalCount);
        return usersResponse.getElements();
    }

    @PostMapping()
    public UsersResponse save(@RequestBody() UsersRequest user){
        String username = "Test";
        UsersResponse response = service.save(user, username);
        RolesResponse rol = ((UsersService)service).setRolOfUser(user.getRolId(), response.getUsersId());
        response.setRol(rol);
        return response;
    }

    @PutMapping("{userId}")
    public UsersResponse update(@PathVariable("userId") int userId, @RequestBody() UsersUpdate user){
        String username = "Test";
        UsersResponse response = service.update(user, userId, username);
        return response;
    }


    @DeleteMapping("{userId}")
    public void delete(@PathVariable("userId") int userId) {
        service.delete(userId);
    }
}
