package com.ProductsApi.ProductsApi.Model;

import com.ProductsApi.ProductsApi.Abstractions.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity()
@Table(name = "permissions", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"description"})
})
@Getter()
@AllArgsConstructor
@NoArgsConstructor
public class Permissions implements BaseEntity<Integer> {

    @Id() @Column(name = "permissions_id") @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "roles_policies",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns =  @JoinColumn(name = "rol_id")
    )
    private Set<Roles> roles;

    @Column(name = "created_at")
    @CreatedDate()
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp()
    private Date updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column
    private boolean status;

    public Permissions(String d, String u){
        description = d;
        createdBy = u;
        updatedBy = u;
        status = true;
    }

    @Override
    public void setId(Integer integer) {
        id = integer;
    }

    @Override
    public Integer getId() {
        return id;
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

}
