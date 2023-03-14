package com.ProductsApi.ProductsApi.Model;

import com.ProductsApi.ProductsApi.Abstractions.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Date;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
@Getter
public class Users implements BaseEntity<Integer> {

    @Id() @Column(name = "users_id") @GeneratedValue(strategy = GenerationType.AUTO)
    private int usersId;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column
    private String street;

    @Column
    private int height;

    @Column
    private long dni;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @ManyToOne()
    @JoinColumn(name = "rol_id")
    private Roles rol;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;
    @Column
    private boolean status;

    public Users(String n, String l, String s, int h, long d, String e, String p){
        name = n;
        lastname = l;
    }



    @Override
    public void setId(Integer integer) {
        usersId = integer;
    }

    @Override
    public Integer getId() {
        return usersId;
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
        createdBy = username;
    }

    @Override
    public void setUpdateAt(Date date) {
        updatedAt = date;
    }
}
