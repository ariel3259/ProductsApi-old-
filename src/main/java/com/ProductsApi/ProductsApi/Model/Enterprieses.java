package com.ProductsApi.ProductsApi.Model;

import com.ProductsApi.ProductsApi.Abstractions.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table
public class Enterprieses implements BaseEntity<Integer> {
    @Override
    public void setId(Integer integer) {

    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public boolean getStatus() {
        return false;
    }

    @Override
    public void setStatus(boolean status) {

    }

    @Override
    public void setUpdatedBy(String username) {

    }

    @Override
    public void setUpdateAt(Date date) {

    }
}
