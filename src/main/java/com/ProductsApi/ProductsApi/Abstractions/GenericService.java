package com.ProductsApi.ProductsApi.Abstractions;


import java.io.Serializable;
import java.util.Optional;

public interface GenericService<ID extends Serializable, Ent extends BaseEntity<ID>, Req, Res, Upd> {
     PageResponse<Res> getAll(Optional<Integer> offset, Optional<Integer> limit);
     Res getOne(ID id);
     Res save(Req request, String username);
     Res update(Upd updateRequest, ID id, String username);
     void delete(ID id);
}
