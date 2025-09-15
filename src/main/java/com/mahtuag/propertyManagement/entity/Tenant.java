package com.mahtuag.propertyManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahtuag.propertyManagement.model.enums.TenantStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Auditable;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tenant")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AttributeOverride(name = "id", column = @Column(name = "tenant_id", nullable = false))
@AllArgsConstructor
@NoArgsConstructor
public class Tenant extends AuditEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TenantStatus status;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Lease> leases;

}
