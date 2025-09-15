package com.mahtuag.propertyManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahtuag.propertyManagement.model.enums.PropertyStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "property")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AttributeOverride(name = "id", column = @Column(name="property_id", nullable = false))
@NoArgsConstructor
@AllArgsConstructor
public class Property extends AuditEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PropertyStatus status = PropertyStatus.AVAILABLE;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Lease> leases;
}
