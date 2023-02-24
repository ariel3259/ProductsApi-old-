package com.ProductsApi.ProductsApi.Abstractions;

import org.springframework.data.domain.Page;

import java.util.List;

public interface Mapper<ID, Ent extends BaseEntity<ID>, Req, Res, Upd>{
    Ent map(Req request, String username);
    Res map(Ent entity);
    PageResponse<Res> map(PageResponse<Ent> entities);
    Ent map(Upd updateRequest, Ent entity, String username);
}
