package com.ProductsApi.ProductsApi.Model;

import com.ProductsApi.ProductsApi.Abstractions.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter()
@Setter
public class Products implements BaseEntity<Integer> {

    @Id()
    @Column(name = "products_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private int stock;
    @ManyToOne()
    @JoinColumn(name = "enterprise_id")
    private Enterprises enterprise;
    @ManyToMany()
    @JoinTable(
            name = "users_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Users> users;
    @Column(name = "created_at")
    @CreatedDate()
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

    public Products(String n, Double p, int s, String u, Enterprises e){
        name = n;
        price = p;
        stock = s;
        createdBy = u;
        updatedBy = u;
        enterprise = e;
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
