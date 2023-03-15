package com.ProductsApi.ProductsApi.Abstractions;

import java.io.Serializable;
import java.sql.Date;

public interface BaseEntity<ID extends Serializable> {

    void setId(ID id);
    ID getId();
    boolean getStatus();
    void setStatus(boolean status);
    void setUpdatedBy(String username);
}
