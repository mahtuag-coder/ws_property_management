package com.mahtuag.propertyManagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "property")
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;
}
