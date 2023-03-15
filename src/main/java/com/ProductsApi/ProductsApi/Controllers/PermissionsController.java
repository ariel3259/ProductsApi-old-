package com.ProductsApi.ProductsApi.Controllers;

import com.ProductsApi.ProductsApi.Dto.PermissionsResponse;
import com.ProductsApi.ProductsApi.Dto.PermissionsResponsePage;
import com.ProductsApi.ProductsApi.Model.Permissions;
import com.ProductsApi.ProductsApi.Services.PermissionsService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api/permissions")
public class PermissionsController {

    @Autowired
    private PermissionsService service;

    @GetMapping()
    public List<PermissionsResponse> getAll(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("limit") Optional<Integer> limit,
            HttpServletResponse httpResponse) {
        Page<Permissions> permissionsPage = service.getAll(page, limit);
        List<Permissions> permissions = permissionsPage.getContent();
        List<PermissionsResponse> response = permissions
                .stream()
                .map(permission -> new PermissionsResponse(permission.getPermissionsId(), permission.getDescription()))
                .toList();
        String xTotalCount = String.valueOf(permissionsPage.getTotalElements());
        httpResponse.setHeader("x-total-count", xTotalCount);
        return response;
    }
}
