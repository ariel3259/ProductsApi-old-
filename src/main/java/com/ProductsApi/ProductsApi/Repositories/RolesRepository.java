package com.ProductsApi.ProductsApi.Repositories;

import com.ProductsApi.ProductsApi.Abstractions.PageResponse;
import com.ProductsApi.ProductsApi.Abstractions.Repository;
import com.ProductsApi.ProductsApi.Dto.RolesPage;
import com.ProductsApi.ProductsApi.Model.Roles;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RolesRepository implements Repository<Integer, Roles> {

    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public PageResponse<Roles> getAll(Optional<Integer> offset, Optional<Integer> limit) {
        List<Roles> roles;
        long totalItems;
        int of = offset.orElse(0);
        int li = limit.orElse(10);
        //Get the count of elements
        String countQuery = "SELECT COUNT(r) FROM Roles r WHERE r.status = true";
        Query countResult = entityManager.createQuery(countQuery);
        totalItems = (long) countResult.getSingleResult();
        //finding elements by status
        String findQuery = "SELECT r FROM Roles r WHERE r.status = true";
        Query findResult = entityManager.createNativeQuery(findQuery, Roles.class);
        //making pagination
        findResult.setFirstResult(of);
        findResult.setMaxResults(li);
        roles = findResult.getResultList();
        return new RolesPage(roles, totalItems);
    }

    @Override
    public Roles getById(Integer id) {
        Roles rol;
        String rolQuery = "SELECT r FROM Roles r WHERE r.rolesId = :rolesId AND r.status = true";
        Query rolResult = entityManager.createQuery(rolQuery, Roles.class);
        rolResult.setParameter("rolesId", id);
        rol = (Roles) rolResult.getSingleResult();
        if(rol == null) return new Roles();
        else return rol;
    }

    @Override
    public Roles save(Roles entity) {
        if (exists(entity)) return new Roles();

        //Creating a rol
        entityManager.getTransaction().begin();
        Roles rolCreated =entityManager.merge(entity);
        entityManager.getTransaction().commit();

        return rolCreated;
    }

    @Override
    public Roles update(Roles entity) {
        if(exists(entity)) return new Roles();

        //Modifying a  rol
        entityManager.getTransaction().begin();
        Roles rolModified = entityManager.merge(entity);
        entityManager.getTransaction().commit();

        return rolModified;
    }

    @Override
    public void delete(Integer id) {
        String deleteQuery = "UPDATE FROM Roles r.status = false WHERE r.rolesId = :rolesId AND r.status = true";
        Query deleteResult = entityManager.createQuery(deleteQuery);
        deleteResult.setParameter("rolesId", id);
        deleteResult.executeUpdate();
    }

    private boolean exists(Roles entity){
        String existsQuery = "SELECT COUNT(r) FROM Roles r WHERE r.description = :description";
        Query existsResult= entityManager.createQuery(existsQuery);
        existsResult.setParameter("description", entity.getDescription());
        long counter = (long) existsResult.getSingleResult();
        return counter > 0;
    }

}
