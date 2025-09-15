package com.mahtuag.propertyManagement.entity;

import com.mahtuag.propertyManagement.model.enums.LeaseStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "lease")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ls_id")
    private Long id;

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
