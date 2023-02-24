package com.ProductsApi.ProductsApi.Abstractions;

import java.sql.Date;

public interface BaseEntity<ID> {

    void setId(ID id);
    ID getId();
    boolean getStatus();
    void setStatus(boolean status);
    void setUpdatedBy(String username);
    void setUpdateAt(Date date);
}
