package com.ProductsApi.ProductsApi.Model;

import com.ProductsApi.ProductsApi.Abstractions.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;

@Entity
@Table(name = "enterprises", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Enterprises implements BaseEntity<Integer> {

    @Id()
    @Column(name = "enterprises_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int enterprisesId;
    @Column(unique = true)
    private String name;
    @Column
    private String description;
    @Column
    private String street;
    @Column
    private int height;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column
    private boolean status;

    public Enterprises(String n, String d, String s, int h, String u, Users us){
        name = n;
        description = d;
        street = s;
        height = h;
        updatedBy = u;
        createdBy = u;
        status = true;
        user = us;
    }

    @Override
    public void setId(Integer integer) {
        enterprisesId = integer;
    }

    @Override
    public Integer getId() {
        return enterprisesId;
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
