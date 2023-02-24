package com.ProductsApi.ProductsApi.Model;

import com.ProductsApi.ProductsApi.Abstractions.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity()
@Table(name="roles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "description")
})
@AllArgsConstructor()
@Getter()
public class Roles implements BaseEntity<Integer> {
    @Id() @Column(name="roles_id") @GeneratedValue(strategy = GenerationType.AUTO)
    private int rolesId;

    @Setter
    @Column(unique = true)
    private String description;

    @Column()
    private boolean status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    public Roles(){
        rolesId = 0;
        description = "";
        status = false;
        updatedBy = "";
        createdBy = "";
        updatedAt = new Date(System.currentTimeMillis());
        createdAt = new Date(System.currentTimeMillis());
    }
    public Roles(String d, String u) {
        Date today = new Date(System.currentTimeMillis());
        description = d;
        createdBy = u;
        updatedBy = u;
        createdAt = today;
        updatedAt = today;
        status = true;
    }

    @Override
    public void setId(Integer integer) {
        rolesId = integer;
    }
    @Override
    public Integer getId() {
        return rolesId;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void setUpdatedBy(String username) {
        updatedBy = username;
    }

    @Override
    public void setUpdateAt(Date date) {
        updatedAt = date;
    }
}
