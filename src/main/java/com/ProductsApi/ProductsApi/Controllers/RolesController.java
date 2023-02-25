package com.ProductsApi.ProductsApi.Controllers;

import com.ProductsApi.ProductsApi.Abstractions.GenericService;
import com.ProductsApi.ProductsApi.Abstractions.PageResponse;
import com.ProductsApi.ProductsApi.Dto.RolesRequest;
import com.ProductsApi.ProductsApi.Dto.RolesResponse;
import com.ProductsApi.ProductsApi.Dto.RolesUpdate;
import com.ProductsApi.ProductsApi.Model.Roles;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<RolesResponse> getAll(@RequestParam("offset")Optional<Integer> offset, @RequestParam("limit") Optional<Integer> limit, HttpServletResponse response){
        PageResponse<RolesResponse> rolesResponse = service.getAll(offset, limit);
        response.addDateHeader("x-total-count", rolesResponse.getTotalItems());
        return rolesResponse.getElements();
    }

    @GetMapping("{id}")
    public RolesResponse getOne(@PathVariable("id") int id) {
        return service.getOne(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RolesResponse save(@RequestBody() RolesRequest request) {
        return service.save(request, "Development");
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
