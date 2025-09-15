package com.mahtuag.propertyManagement.entity;

import com.mahtuag.propertyManagement.model.enums.LeaseStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "lease")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AttributeOverride(name = "id", column = @Column(name = "lease_id", nullable = false))
@AllArgsConstructor
@NoArgsConstructor
public class Lease extends AuditEntity {

    @Column(name = "ls_strt_date", nullable = false)
    private LocalDate leaseStartDate;
    @Column(name = "ls_end_dte", nullable = false)
    private LocalDate leaseEndDate;

    @Column(nullable = false)
    private Double rent;
    @Column(nullable = false)
    private Double deposit;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LeaseStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
}
