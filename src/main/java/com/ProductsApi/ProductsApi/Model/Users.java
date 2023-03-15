package com.ProductsApi.ProductsApi.Model;

import com.ProductsApi.ProductsApi.Abstractions.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
@Getter
@Setter
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
    @CreatedDate()
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp()
    private Date updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @OneToMany(mappedBy = "user")
    private Set<Enterprises> enterprises;

    @ManyToMany()
    @JoinTable(
            name = "products_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Products> products;

    @Column
    private boolean status;

    public Users(String n, String l, String s, int h, long d, String e, String p, String u, Roles r){
        name = n;
        lastname = l;
        street = s;
        height = h;
        dni = d;
        email = e;
        password = p;
        createdBy = u;
        updatedBy = u;
        rol = r;
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

}
