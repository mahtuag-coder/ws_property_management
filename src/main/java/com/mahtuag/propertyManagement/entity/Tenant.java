package com.mahtuag.propertyManagement.entity;

import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tenant")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenant_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private TenantStatus status;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    List<Lease> leases;


}
