package com.ProductsApi.ProductsApi.Controllers;

import com.ProductsApi.ProductsApi.Abstractions.GenericService;
import com.ProductsApi.ProductsApi.Abstractions.PageResponse;
import com.ProductsApi.ProductsApi.Dto.*;
import com.ProductsApi.ProductsApi.Model.Roles;
import com.ProductsApi.ProductsApi.Services.RolesService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private GenericService<Integer, Roles, RolesRequest, RolesResponse, RolesUpdate> service;

    @GetMapping
    public List<RolesResponse> getAll(@RequestParam("page")Optional<Integer> offset, @RequestParam("limit") Optional<Integer> limit, HttpServletResponse response){
        PageResponse<RolesResponse> rolesResponse = service.getAll(offset, limit);
        long totalCount = rolesResponse.getTotalItems();
        String xTotalCount = String.valueOf(totalCount);
        response.addHeader("x-total-count", xTotalCount);
        return rolesResponse.getElements();
    }

    @GetMapping("permissions")
    public List<RolesPermissionsResponse> getAllRolesPermissions(@RequestParam("page")Optional<Integer> offset, @RequestParam("limit")Optional<Integer> limit, HttpServletResponse response){
        PageResponse<RolesPermissionsResponse> rolesPermissionsResponsePage = ((RolesService)service).getAllRolesPermissions(offset, limit);
        long totalCount = rolesPermissionsResponsePage.getTotalItems();
        String xTotalCount = String.valueOf(totalCount);
        response.addHeader("x-total-count", xTotalCount);
        List<RolesPermissionsResponse> rolesPermissionsResponse = rolesPermissionsResponsePage.getElements();
        return rolesPermissionsResponse;
    }

    @GetMapping("{rolId}/permissions")
    public ResponseEntity<RolesPermissionsResponse> getOneRolPermission(@PathVariable("rolId") int rolId) {
        RolesPermissionsResponse response = ((RolesService)service).getOneRolPermissions(rolId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public RolesResponse getOne(@PathVariable("id") int id) {
        return service.getOne(id);
    }

    @PutMapping("{rolId}/permissions")
    public ResponseEntity<RolesPermissionsResponse> modify(@PathVariable("rolId") int rolId, @RequestBody() RolesPermissionsRequest request ) {
        RolesPermissionsResponse response = ((RolesService)service).update(request, rolId);
        return ResponseEntity.ok(response);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<RolesResponse> save(@RequestBody() RolesRequest request) {
        RolesResponse response = service.save(request, "Development");
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public RolesResponse update(@RequestBody() RolesUpdate updateRequest, @PathVariable("id") int id) {
        return service.update(updateRequest, id, "development");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RolesResponse handleValidation(MethodArgumentNotValidException ex) {
        return new RolesResponse();
    }
}
