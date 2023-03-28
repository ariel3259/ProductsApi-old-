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

@Entity()
@Table(name="roles", uniqueConstraints = {
        @UniqueConstraint(columnNames = "description")
})
@AllArgsConstructor()
@NoArgsConstructor
@Getter()
@Setter
public class Roles implements BaseEntity<Integer> {
    @Id() @Column(name="roles_id") @GeneratedValue(strategy = GenerationType.AUTO)
    private int rolesId;

    @Setter
    @Column(unique = true)
    private String description;

    @Column()
    private boolean status;

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

    @OneToMany(mappedBy = "rol")
    private Set<Users> users;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "roles_policies",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns =  @JoinColumn(name = "permission_id")
    )
    private Set<Permissions> permissions;

    public Roles(String d, String u) {
        description = d;
        createdBy = u;
        updatedBy = u;
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

}
